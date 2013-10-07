package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.util.List;

/**
 *
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
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
    public Object evaluate(Object data) {
        Object value = valueOp.evaluate(data);
        for (int i = 0; i<whenExprOps.size(); i++) {
            if (cmp(value, whenExprOps.get(i).evaluate(data)) == 0) {
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
        if (!valueOp.isDeterministic() || (elseOp != null && !elseOp.isDeterministic())) {
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
        StringBuilder builder = new StringBuilder("CASE (" + valueOp + ") (");
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
