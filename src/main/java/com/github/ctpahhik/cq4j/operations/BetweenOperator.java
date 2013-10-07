package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class BetweenOperator extends AbstractOperator<Boolean> {

    private IOperator<? extends Comparable> valueOp;
    private IOperator<? extends Comparable> lowerOp;
    private IOperator<? extends Comparable> upperOp;

    public BetweenOperator(IOperator<? extends Comparable> valueOp, IOperator<? extends Comparable> lowerOp, IOperator<? extends Comparable> upperOp) {
        this.valueOp = valueOp;
        this.lowerOp = lowerOp;
        this.upperOp = upperOp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Boolean evaluate(Object data) {
        Comparable value = valueOp.evaluate(data);
        if (value == null) {
            return null;
        }
        Comparable lower = lowerOp.evaluate(data);
        Comparable upper = upperOp.evaluate(data);
        Boolean result = null;
        if (lower != null) {
            if (value.compareTo(lower) >= 0) {
                result = true;
            } else {
                return false;
            }
        }
        if (upper != null) {
            if (value.compareTo(upper) <= 0) {
                return result;
            } else {
                return false;
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean isDeterministic() {
        return valueOp.isDeterministic() && lowerOp.isDeterministic() && upperOp.isDeterministic();
    }

    @Override
    public String toString() {
        return "(" + valueOp + ") BETWEEN (" + lowerOp + ") AND (" + upperOp + ")";
    }
}
