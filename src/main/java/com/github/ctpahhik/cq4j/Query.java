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
import java.util.List;

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

    public Boolean isTrue(T data) {
        return (Boolean) operator.evaluate(data);
    }

    public Collection<T> filter(Collection<T> collection) {
        List<T> result = new ArrayList<T>();
        for (T data : collection) {
            if (isTrue(data)) {
                result.add(data);
            }
        }
        return  result;
    }

    @Override
    public String toString() {
        return "Query{" +
                "query='" + query + '\'' +
                ", operator=" + operator +
                '}';
    }
}
