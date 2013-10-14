package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.data.BeanCodeGenDataAdapter;
import com.github.ctpahhik.cq4j.data.BeanInvokeDynamicDataAdapter;
import com.github.ctpahhik.cq4j.execution.CallableFilteringTask;
import com.github.ctpahhik.cq4j.execution.RecursiveFilteringTask;
import com.github.ctpahhik.cq4j.functions.FunctionsFactory;
import com.github.ctpahhik.cq4j.grammar.BaseSqlConditionCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlLexer;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import java.io.StringReader;
import java.util.*;
import java.util.concurrent.*;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class Filter<T> {

    private static boolean forkJoinSupported;
    private static boolean invokeDynamicSupported;
    private static ExecutorService executor;

    private static final int SPLIT_SIZE = 50; //TODO: find optimal
    private static boolean debug = false;
    private String query;
    private IOperator operator;

    static {
        executor = new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors(), 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        try {
            Class.forName("java.util.concurrent.ForkJoinPool");
            forkJoinSupported = true;
        } catch (Exception e) {
            forkJoinSupported = false;
        }
        try {
            Class.forName("java.lang.invoke.InvokeDynamic");
            invokeDynamicSupported = true;
        } catch (Exception e) {
            invokeDynamicSupported = false;
        }
        setInvokeDynamicSupported(false);  //TODO: remove when adapter is fixed.
    }

    public Filter(String query) throws Exception {
        this(query, (IDataAdapter<T>) null);
    }

    public Filter(String query, Class<T> clazz) throws Exception {
        this(query, getDefaultBeanDataAdapter(clazz));
    }

    public Filter(String query, IDataAdapter<T> adapter) throws Exception {
        this.query = query;
        Lexer lexer = new BaseSqlLexer(new ANTLRInputStream(new StringReader(query)));
        TokenStream tStream = new CommonTokenStream(lexer);
        BaseSqlParser parser = new BaseSqlParser(tStream);
        Map<String, IDataAdapter> adapters = new HashMap<String, IDataAdapter>();
        adapters.put("", adapter);
        BaseSqlConditionCompilationVisitor visitor = new BaseSqlConditionCompilationVisitor(adapters, new FunctionsFactory());
        operator = parser.simpleCondition().accept(visitor);
        if (isDebug()) {
            System.out.println(this);
        }
    }

    private static <V> IDataAdapter<V> getDefaultBeanDataAdapter(Class<V> clazz) {
        if (invokeDynamicSupported) {
            return new BeanInvokeDynamicDataAdapter<V>(clazz);
        } else {
            return new BeanCodeGenDataAdapter<V>(clazz);
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        Filter.debug = debug;
    }

    public static boolean isForkJoinSupported() {
        return forkJoinSupported;
    }

    public static void setForkJoinSupported(boolean forkJoinSupported) {
        Filter.forkJoinSupported = forkJoinSupported;
    }

    public static boolean isInvokeDynamicSupported() {
        return invokeDynamicSupported;
    }

    public static void setInvokeDynamicSupported(boolean invokeDynamicSupported) {
        Filter.invokeDynamicSupported = invokeDynamicSupported;
    }

    public Object evaluate(T data) {
        return operator.evaluate(data);
    }

    public boolean isTrue(T data) {
        Boolean result = (Boolean) operator.evaluate(data);
        return (result != null && result);
    }

    public Collection<T> filter(Collection<T> dataSource) {
        List<T> result = new ArrayList<T>();
        for (T data : dataSource) {
            if ( data!=null && isTrue(data) ) {
                result.add(data);
            }
        }
        return  result;
    }

    public Collection<T> filterParallel(Collection<T> dataSource) {
        List<T> dataList;
        if (dataSource instanceof List) {
            dataList = (List<T>) dataSource;
        } else {
            dataList = new ArrayList<T>(dataSource);
        }
        if (forkJoinSupported) {
            RecursiveFilteringTask<T> task = new RecursiveFilteringTask<T>(this, dataList);
            return new ForkJoinPool().invoke(task);
        } else {
            int size = dataSource.size();
            Collection<T> result = new ArrayList<T>();
            Collection<Future<Collection<T>>> tasks = new ArrayList<Future<Collection<T>>>(size / SPLIT_SIZE);
            int prev = 0;
            for (int curr = Math.min(SPLIT_SIZE, size); curr <= size; curr += SPLIT_SIZE) {
                CallableFilteringTask<T> task = new CallableFilteringTask<T>(this, dataList.subList(prev, Math.min(curr, size)));
                tasks.add(executor.submit(task));
                prev = curr;
            }
            try {
                for (Future<Collection<T>> future : tasks) {
                    result.addAll(future.get());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return result;
        }
    }

    public Iterable<T> getIterable(final Iterable<T> dataSource) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new QueryIterator(dataSource.iterator());
            }
        };
    }

    @Override
    public String toString() {
        return "Filter{" +
                "query='" + query + '\'' +
                ", operator=" + operator +
                '}';
    }

    private class QueryIterator implements Iterator<T> {

        private Iterator<T> dataSource;
        private T next;

        private QueryIterator(Iterator<T> dataSource) {
            this.dataSource = dataSource;
        }

        @Override
        public boolean hasNext() {
            if (next != null) {
                return true;
            }
            while (dataSource.hasNext()) {
                T current = dataSource.next();
                if ( current!=null && isTrue(current) ) {
                    next = current;
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            while (hasNext()) {
                if (next != null) {
                    T current = next;
                    next = null;
                    return current;
                }
            }
            throw new IllegalStateException("Iterator has no more elements.");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
