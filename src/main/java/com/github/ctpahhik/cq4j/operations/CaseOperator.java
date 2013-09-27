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
public class CaseOperator extends AbstractOperator {

    private IOperator valueOp;
    private List<IOperator> whenExprOps;
    private List<IOperator> thenExprOps;
    private IOperator elseOp;

    public CaseOperator(IOperator valueOp, List<IOperator> whenExprOps, List<IOperator> thenExprOps, IOperator elseOp) {
        this.valueOp = valueOp;
        this.whenExprOps = whenExprOps;
        this.thenExprOps = thenExprOps;
        this.elseOp = elseOp;
    }

    @Override
    public Object evaluate() {
        return null; //TODO: implement
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CASE (" + valueOp + ") (");
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
