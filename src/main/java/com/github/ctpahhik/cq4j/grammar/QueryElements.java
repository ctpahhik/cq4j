package com.github.ctpahhik.cq4j.grammar;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.util.List;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class QueryElements {
    private SelectElements select;
    private FromElements from;
    private IOperator<Boolean> where;
    private List<OrderingComparator> orderBy;
    private List<IOperator> groupBy;

    public SelectElements getSelect() {
        return select;
    }

    public void setSelect(SelectElements select) {
        this.select = select;
    }

    public FromElements getFrom() {
        return from;
    }

    public void setFrom(FromElements from) {
        this.from = from;
    }

    public IOperator<Boolean> getWhere() {
        return where;
    }

    public void setWhere(IOperator<Boolean> where) {
        this.where = where;
    }

    public List<OrderingComparator> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<OrderingComparator> orderBy) {
        this.orderBy = orderBy;
    }

    public List<IOperator> getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(List<IOperator> groupBy) {
        this.groupBy = groupBy;
    }

    @Override
    public String toString() {
        return "QueryElements{" +
                "select='" + select + '\'' +
                ", from='" + from + '\'' +
                ", where=" + where +
                ", orderBy=" + orderBy +
                ", groupBy=" + groupBy +
                '}';
    }
}
