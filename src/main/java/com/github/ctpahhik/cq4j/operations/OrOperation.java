package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

/**
 *
 * Boolean OR operation.
 *
 * author: ctpahhik (mostovliuk@gmail.com)
 */
public class OrOperation extends AbstractOperation<Boolean> {

    private IOperation<Boolean> leftOp;
    private IOperation<Boolean> rightOp;

    public OrOperation(IOperation<Boolean> leftOp, IOperation<Boolean> rightOp) {
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
