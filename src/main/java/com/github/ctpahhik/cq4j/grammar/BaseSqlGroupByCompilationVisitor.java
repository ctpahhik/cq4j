// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.Map;

/**
 * This class provides an empty implementation of {@link com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class BaseSqlGroupByCompilationVisitor extends BaseSqlAbstractVisitor<List<IOperator>> implements BaseSqlVisitor<List<IOperator>> {

    private Map<String, IDataAdapter> dataAdapters;

    public BaseSqlGroupByCompilationVisitor(Map<String, IDataAdapter> dataAdapters) {
        this.dataAdapters = dataAdapters;
    }

    @Override
    public List<IOperator> visitGroupByClause(@NotNull BaseSqlParser.GroupByClauseContext ctx) {
        return null;
    }
}