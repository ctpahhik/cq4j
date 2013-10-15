// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar.from;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.grammar.BaseSqlAbstractVisitor;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Map;

/**
 * This class provides an empty implementation of {@link com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class BaseSqlFromCompilationVisitor extends BaseSqlAbstractVisitor<FromElements> implements BaseSqlVisitor<FromElements> {

    private Map<String, IDataAdapter> dataAdapters;

    public BaseSqlFromCompilationVisitor(Map<String, IDataAdapter> dataAdapters) {
        this.dataAdapters = dataAdapters;
    }

    @Override
    public FromElements visitFromExpression(@NotNull BaseSqlParser.FromExpressionContext ctx) {
        return new FromElements(dataAdapters);
    }
}