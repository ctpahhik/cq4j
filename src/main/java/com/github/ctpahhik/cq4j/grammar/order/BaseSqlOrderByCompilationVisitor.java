// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar.order;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.BaseSqlAbstractVisitor;
import com.github.ctpahhik.cq4j.grammar.from.FromElements;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import com.github.ctpahhik.cq4j.grammar.where.BaseSqlConditionCompilationVisitor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides an empty implementation of {@link com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class BaseSqlOrderByCompilationVisitor extends BaseSqlAbstractVisitor<OrderingComparator> implements BaseSqlVisitor<OrderingComparator> {

    private BaseSqlConditionCompilationVisitor conditionVisitor ;

    public BaseSqlOrderByCompilationVisitor(FromElements from) {
        this.conditionVisitor = new BaseSqlConditionCompilationVisitor(from);
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderingComparator visitOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx) {
        List<BaseSqlParser.OrderByElementContext> orderByElements = ctx.orderByElement();

        List<OrderingElement> result = new ArrayList<OrderingElement>(orderByElements.size());
        for (BaseSqlParser.OrderByElementContext element : orderByElements) {
            IOperator<Comparable> operator = element.condition().accept(conditionVisitor);
            if (element.direction == null) {
                result.add(new OrderingElement(operator));
            } else if (element.direction.getType() == BaseSqlParser.ASC) {
                result.add(new OrderingElement(operator, true));
            } else if (element.direction.getType() == BaseSqlParser.DESC) {
                result.add(new OrderingElement(operator, false));
            } else {
                throw new IllegalArgumentException("Unknown ordering direction type: " + element.direction);
            }
        }
        return new OrderingComparator(result);
    }
}