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
