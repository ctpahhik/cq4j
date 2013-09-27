package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 *
 * Boolean AND operation.
 * Violates 3VL Kleene logic for better laziness as it's enough for now.
 *
 * author: ctpahhik (mostovliuk@gmail.com)
 */
public class AndOperator extends AbstractOperator<Boolean> {

    private IOperator<Boolean> leftOp;
    private IOperator<Boolean> rightOp;

    public AndOperator(IOperator<Boolean> leftOp, IOperator<Boolean> rightOp) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
    }

    @Override
    public Boolean evaluate(Object data) {
        Boolean left = leftOp.evaluate(data);
        if (left == null || !left) {
            return false; //lazy evaluation if first param is null or false
        }

        return rightOp.evaluate(data);
    }

    @Override
    public String toString() {
        return "(" + leftOp + ") AND (" + rightOp + ')';
    }
}
