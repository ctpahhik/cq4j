package com.github.ctpahhik.cq4j.grammar;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class QueryElements {
    private IOperator<Boolean> whereClause;
    private String from;


    public IOperator<Boolean> getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(IOperator<Boolean> whereClause) {
        this.whereClause = whereClause;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "QueryElements{" +
                "whereClause=" + whereClause +
                ", from='" + from + '\'' +
                '}';
    }
}
