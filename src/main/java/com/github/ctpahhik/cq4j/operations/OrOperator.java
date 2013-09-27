package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 *
 * Boolean OR operation.
 *
 * author: ctpahhik (mostovliuk@gmail.com)
 */
public class OrOperator extends AbstractOperator<Boolean> {

    private IOperator<Boolean> leftOp;
    private IOperator<Boolean> rightOp;

    public OrOperator(IOperator<Boolean> leftOp, IOperator<Boolean> rightOp) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
    }

    @Override
    public Boolean evaluate() {
        Boolean left = leftOp.evaluate();
        if (left != null && left) {
            return true;  //lazy evaluation if first param is true
        }
        Boolean right = rightOp.evaluate();
        if (right != null && right) {
            return true;
        }
        if (left == null || right == null) {
            return null;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + leftOp + ") OR (" + rightOp + ')';
    }
}
