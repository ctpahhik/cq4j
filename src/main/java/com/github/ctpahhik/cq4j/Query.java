package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.data.BeanCodeGenDataAdapter;
import com.github.ctpahhik.cq4j.functions.FunctionsFactory;
import com.github.ctpahhik.cq4j.grammar.BaseSqlConditionCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlLexer;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class Query<T> {

    private static boolean debug = false;
    private String query;
    private IOperator operator;

    public Query(String query) throws Exception {
        this(query, (IDataAdapter<T>) null);
    }

    public Query(String query, Class<T> clazz) throws Exception {
        this(query, new BeanCodeGenDataAdapter<T>(clazz));
    }

    public Query(String query, IDataAdapter<T> adapter) throws Exception {
        this.query = query;
        Lexer lexer = new BaseSqlLexer(new ANTLRInputStream(new StringReader(query)));
        TokenStream tStream = new CommonTokenStream(lexer);
        BaseSqlParser parser = new BaseSqlParser(tStream);
        BaseSqlConditionCompilationVisitor visitor = new BaseSqlConditionCompilationVisitor(adapter, new FunctionsFactory());
        operator = parser.simpleCondition().accept(visitor);
        if (isDebug()) {
            System.out.println(this);
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        Query.debug = debug;
    }

    public Object evaluate(T data) {
        return operator.evaluate(data);
    }

    public boolean isTrue(T data) {
        Boolean result = (Boolean) operator.evaluate(data);
        return (result != null && result);
    }

    public Collection<T> filter(Iterable<T> dataSource) {
        List<T> result = new ArrayList<T>();
        for (T data : dataSource) {
            if ( data!=null && isTrue(data) ) {
                result.add(data);
            }
        }
        return  result;
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
        return "Query{" +
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
