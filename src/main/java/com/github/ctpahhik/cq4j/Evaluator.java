package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.functions.FunctionsFactory;
import com.github.ctpahhik.cq4j.grammar.BaseSqlConditionCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlLexer;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import java.io.StringReader;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class Evaluator {

    private String query;
    private IOperator operator;

    public Evaluator(String query, IDataAdapter adapter) throws Exception {
        this.query = query;
        Lexer lexer = new BaseSqlLexer(new ANTLRInputStream(new StringReader(query)));
        TokenStream tStream = new CommonTokenStream(lexer);
        BaseSqlParser parser = new BaseSqlParser(tStream);
        BaseSqlConditionCompilationVisitor visitor = new BaseSqlConditionCompilationVisitor(adapter, new FunctionsFactory());
        operator = parser.simpleCondition().accept(visitor);
    }

    public Object evaluate(Object data) {
        return operator.evaluate(data);
    }

    public Boolean isTrue(Object data) {
        return (Boolean) operator.evaluate(data);
    }

    @Override
    public String toString() {
        return "Evaluator{" +
                "query='" + query + '\'' +
                ", operator=" + operator +
                '}';
    }
}
