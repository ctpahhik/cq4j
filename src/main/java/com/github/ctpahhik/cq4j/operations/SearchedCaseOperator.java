package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.util.List;

/**
 *
 * Boolean AND operation.
 * Violates 3VL Kleene logic for better laziness as it's enough for now.
 *
 * author: ctpahhik (mostovliuk@gmail.com)
 */
public class SearchedCaseOperator extends AbstractOperator {

    private List<IOperator<Boolean>> whenExprOps;
    private List<IOperator> thenExprOps;
    private IOperator elseOp;

    public SearchedCaseOperator(List<IOperator<Boolean>> whenExprOps, List<IOperator> thenExprOps, IOperator elseOp) {
        this.whenExprOps = whenExprOps;
        this.thenExprOps = thenExprOps;
        this.elseOp = elseOp;
    }

    @Override
    public Object evaluate(Object data) {
        return null; //TODO: implement
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CASE (");
        for (int i=0; i<whenExprOps.size(); i++) {
            builder .append("WHEN (")
                    .append(whenExprOps.get(i))
                    .append(") THEN (")
                    .append(thenExprOps.get(i))
                    .append(')');
        }
        builder.append(") ELSE (").append(elseOp).append(')');
        return builder.toString();
    }
}
