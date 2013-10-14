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
        FromElements from = new BaseSqlFromCompilationVisitor(dataAdapters).visitFromExpression(ctx.fromExpression());
        result.setFrom(from);
        SelectElements select = new BaseSqlSelectCompilationVisitor(from.getDataAdapters()).visitSelectExpression(ctx.selectExpression());
        result.setSelect(select);
        IOperator<Boolean> where = new BaseSqlConditionCompilationVisitor(from.getDataAdapters()).visitWhereClause(ctx.whereClause());
        result.setWhere(where);
        List<OrderingComparator> orderBy = new BaseSqlOrderByCompilationVisitor(from.getDataAdapters()).visitOrderByClause(ctx.orderByClause());
        result.setOrderBy(orderBy);
        List<IOperator> groupBy = new BaseSqlGroupByCompilationVisitor(from.getDataAdapters()).visitGroupByClause(ctx.groupByClause());
        result.setGroupBy(groupBy);

        return result;
    }
}