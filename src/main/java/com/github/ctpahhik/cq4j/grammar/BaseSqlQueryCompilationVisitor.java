package com.github.ctpahhik.cq4j.grammar;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseSqlQueryCompilationVisitor extends BaseSqlAbstractVisitor<QueryElements> implements BaseSqlVisitor<QueryElements> {

    private Map<String, IDataAdapter> dataAdapters  = new HashMap<String, IDataAdapter>();

    public BaseSqlQueryCompilationVisitor(Class... classes) {
        for (Class clazz : classes) {
            dataAdapters.put(clazz.getSimpleName().toLowerCase(), getDefaultDataAdapter(clazz));
        }
    }

    @SuppressWarnings("unchecked")
	@Override public QueryElements visitQuery(@NotNull BaseSqlParser.QueryContext ctx) {
        QueryElements result = new QueryElements();
        FromElements from = ctx.fromExpression().accept(new BaseSqlFromCompilationVisitor(dataAdapters));
        result.setFrom(from);
        SelectElements select = ctx.selectExpression().accept(new BaseSqlSelectCompilationVisitor(from.getDataAdapters()));
        result.setSelect(select);
        if (ctx.whereClause() != null) {
            IOperator<Boolean> where = ctx.whereClause().accept(new BaseSqlConditionCompilationVisitor(from.getDataAdapters()));
            result.setWhere(where);
        }
        if (ctx.orderByClause() != null) {
            List<OrderingComparator> orderBy = ctx.orderByClause().accept(new BaseSqlOrderByCompilationVisitor(from.getDataAdapters()));
            result.setOrderBy(orderBy);
        }
        if (ctx.groupByClause() != null) {
            List<IOperator> groupBy = ctx.groupByClause().accept(new BaseSqlGroupByCompilationVisitor(from.getDataAdapters()));
            result.setGroupBy(groupBy);
        }

        return result;
    }
}