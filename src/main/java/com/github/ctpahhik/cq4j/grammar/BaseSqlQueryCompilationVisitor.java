package com.github.ctpahhik.cq4j.grammar;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.from.BaseSqlFromCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.from.FromElements;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import com.github.ctpahhik.cq4j.grammar.group.BaseSqlGroupByCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.order.BaseSqlOrderByCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.order.OrderingComparator;
import com.github.ctpahhik.cq4j.grammar.select.BaseSqlSelectCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.select.SelectElements;
import com.github.ctpahhik.cq4j.grammar.where.BaseSqlConditionCompilationVisitor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseSqlQueryCompilationVisitor extends BaseSqlAbstractVisitor<QueryElements> implements BaseSqlVisitor<QueryElements> {

    private final Map<String, IDataAdapter> dataAdapters;

    public BaseSqlQueryCompilationVisitor(Map<String, IDataAdapter> dataAdapters) {
        this.dataAdapters = dataAdapters;
    }

    public BaseSqlQueryCompilationVisitor(Class... classes) {
        if (classes.length == 1) {
            Class clazz = classes[0];
            dataAdapters = Collections.singletonMap(clazz.getSimpleName().toLowerCase(), getDefaultDataAdapter(clazz));
        } else {
            dataAdapters = new HashMap<String, IDataAdapter>();
            for (Class clazz : classes) {
                dataAdapters.put(clazz.getSimpleName().toLowerCase(), getDefaultDataAdapter(clazz));
            }
        }
    }

    @SuppressWarnings("unchecked")
	@Override public QueryElements visitQuery(@NotNull BaseSqlParser.QueryContext ctx) {
        QueryElements result = new QueryElements();
        FromElements from = ctx.fromExpression().accept(new BaseSqlFromCompilationVisitor(dataAdapters));
        result.setFrom(from);
        SelectElements select = ctx.selectExpression().accept(new BaseSqlSelectCompilationVisitor(from));
        result.setSelect(select);
        if (ctx.whereClause() != null) {
            IOperator<Boolean> where = ctx.whereClause().accept(new BaseSqlConditionCompilationVisitor(from));
            result.setWhere(where);
        }
        if (ctx.orderByClause() != null) {
            OrderingComparator orderBy = ctx.orderByClause().accept(new BaseSqlOrderByCompilationVisitor(from));
            result.setOrderBy(orderBy);
        }
        if (ctx.groupByClause() != null) {
            List<IOperator> groupBy = ctx.groupByClause().accept(new BaseSqlGroupByCompilationVisitor(from));
            result.setGroupBy(groupBy);
        }

        return result;
    }
}