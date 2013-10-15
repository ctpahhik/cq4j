package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.grammar.BaseSqlQueryCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.QueryElements;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlLexer;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import java.io.StringReader;
import java.util.*;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class SingleTypeQuery<T> {

    private String query;
    private QueryElements elements;
    private Filter<T> filter;

    public SingleTypeQuery(String query) throws Exception {
        this.query = query;
        BaseSqlQueryCompilationVisitor visitor = new BaseSqlQueryCompilationVisitor();
        parse(visitor);
    }

    public SingleTypeQuery(String query, Class clazz) throws Exception {
        this.query = query;
        BaseSqlQueryCompilationVisitor visitor = new BaseSqlQueryCompilationVisitor(clazz);
        parse(visitor);
    }

    public SingleTypeQuery(String query, IDataAdapter<T> adapter) throws Exception {
        this.query = query;
        Map<String, IDataAdapter> adapters = Collections.singletonMap("", (IDataAdapter)adapter);
        BaseSqlQueryCompilationVisitor visitor = new BaseSqlQueryCompilationVisitor(adapters);
        parse(visitor);
    }

    private void parse(BaseSqlQueryCompilationVisitor visitor) throws Exception {
        Lexer lexer = new BaseSqlLexer(new ANTLRInputStream(new StringReader(query)));
        TokenStream tStream = new CommonTokenStream(lexer);
        BaseSqlParser parser = new BaseSqlParser(tStream);
        elements = parser.query().accept(visitor);
        filter = new Filter<T>(query, elements.getWhere());
    }

    public List<Object[]> execute(Collection<T> data) {
        List<Object[]> result = filter.filterForProcessing(data);
        Collections.sort(result, elements.getOrderBy());
        return result;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "query='" + query + '\'' +
                ", elements=" + elements +
                '}';
    }
}
