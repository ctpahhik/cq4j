package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.util.List;

/**
 *
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
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
        for (int i = 0; i<whenExprOps.size(); i++) {
            if (whenExprOps.get(i).evaluate(data)) {
                return thenExprOps.get(i).evaluate(data);
            }
        }
        if (elseOp != null) {
            return elseOp.evaluate(data);
        }
        return null;
    }

    @Override
    //TODO: can be optimized if 'when' is determined and true
    public boolean isDeterministic() {
        if (elseOp != null && !elseOp.isDeterministic()) {
            return false;
        }
        for (int i = 0; i<whenExprOps.size(); i++) {
            if (!whenExprOps.get(i).isDeterministic() || !thenExprOps.get(i).isDeterministic()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CASE (");
        for (int i=0; i<whenExprOps.size(); i++) {
            builder .append(" WHEN (")
                    .append(whenExprOps.get(i))
                    .append(") THEN (")
                    .append(thenExprOps.get(i))
                    .append(')');
        }
        builder.append(") ELSE (").append(elseOp).append(')');
        return builder.toString();
    }
}
