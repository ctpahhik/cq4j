package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

/**
 *
 * Boolean AND operation.
 * Violates 3VL Kleene logic for better laziness as it's enough for now.
 *
 * author: ctpahhik (mostovliuk@gmail.com)
 */
public class AndOperation extends AbstractOperation<Boolean> {

    private IOperation<Boolean> leftOp;
    private IOperation<Boolean> rightOp;

    public AndOperation(IOperation<Boolean> leftOp, IOperation<Boolean> rightOp) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
    }

    @Override
    public Boolean evaluate() {
        Boolean left = leftOp.evaluate();
        if (left == null || !left) {
            return false; //lazy evaluation if first param is null or false
        }

        return rightOp.evaluate();
    }

    @Override
    public String toString() {
        return "(" + leftOp + ") AND (" + rightOp + ')';
    }
}
