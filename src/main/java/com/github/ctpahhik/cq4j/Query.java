package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.data.BeanCodeGenDataAdapter;
import com.github.ctpahhik.cq4j.data.BeanInvokeDynamicDataAdapter;
import com.github.ctpahhik.cq4j.execution.CallableFilteringTask;
import com.github.ctpahhik.cq4j.execution.RecursiveFilteringTask;
import com.github.ctpahhik.cq4j.functions.FunctionsFactory;
import com.github.ctpahhik.cq4j.grammar.BaseSqlConditionCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.BaseSqlQueryCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.QueryElements;
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
import java.util.concurrent.*;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class Query<T> {

    private String query;
    private QueryElements elements;

    public Query(String query) throws Exception {
        this(query, (IDataAdapter<T>) null);
    }

    public Query(String query, Class<T> clazz) throws Exception {
        this(query, getDefaultBeanDataAdapter(clazz));
    }

    public Query(String query, IDataAdapter<T> adapter) throws Exception {
        this.query = query;
        Lexer lexer = new BaseSqlLexer(new ANTLRInputStream(new StringReader(query)));
        TokenStream tStream = new CommonTokenStream(lexer);
        BaseSqlParser parser = new BaseSqlParser(tStream);
        BaseSqlQueryCompilationVisitor visitor = new BaseSqlQueryCompilationVisitor();
        elements = parser.query().accept(visitor);
    }

    private static <V> IDataAdapter<V> getDefaultBeanDataAdapter(Class<V> clazz) {
        return new BeanCodeGenDataAdapter<V>(clazz);
    }

    @Override
    public String toString() {
        return "Filter{" +
                "query='" + query + '\'' +
                ", elements=" + elements +
                '}';
    }
}
