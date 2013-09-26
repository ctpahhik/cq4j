package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class BetweenOperation extends AbstractOperation<Boolean> {

    private IOperation<? extends Comparable> valueOp;
    private IOperation<? extends Comparable> lowerOp;
    private IOperation<? extends Comparable> upperOp;

    public BetweenOperation(IOperation<? extends Comparable> valueOp, IOperation<? extends Comparable> lowerOp, IOperation<? extends Comparable> upperOp) {
        this.valueOp = valueOp;
        this.lowerOp = lowerOp;
        this.upperOp = upperOp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Boolean evaluate() {
        Comparable value = valueOp.evaluate();
        if (value == null) {
            return null;
        }
        Comparable lower = lowerOp.evaluate();
        Comparable upper = upperOp.evaluate();
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
    public String toString() {
        return "(" + valueOp + ") BETWEEN (" + lowerOp + ") AND (" + upperOp + ")";
    }
}
