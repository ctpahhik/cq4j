// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
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
public class BaseSqlOrderByCompilationVisitor extends BaseSqlAbstractVisitor<List<OrderingComparator>> implements BaseSqlVisitor<List<OrderingComparator>> {

    private BaseSqlConditionCompilationVisitor conditionVisitor ;

    public BaseSqlOrderByCompilationVisitor(Map<String, IDataAdapter> dataAdapters) {
        this.conditionVisitor = new BaseSqlConditionCompilationVisitor(dataAdapters);
    }

    @Override
    public List<OrderingComparator> visitOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx) {
        List<BaseSqlParser.OrderByElementContext> orderByElements = ctx.orderByElement();

        List<OrderingComparator> result = new ArrayList<OrderingComparator>(orderByElements.size());
        for (BaseSqlParser.OrderByElementContext element : orderByElements) {
            IOperator<Comparable> operator = element.condition().accept(conditionVisitor);
            if (element.direction == null) {
                result.add(new OrderingComparator(operator));
            } else if (element.direction.getType() == BaseSqlParser.ASC) {
                result.add(new OrderingComparator(operator, true));
            } else if (element.direction.getType() == BaseSqlParser.DESC) {
                result.add(new OrderingComparator(operator, false));
            } else {
                throw new IllegalArgumentException("Unknown ordering direction type: " + element.direction);
            }
        }
        return result;
    }
}