package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class IsNullOperation extends AbstractOperation<Boolean> {

    private IOperation valueOp;

    public IsNullOperation(IOperation valueOp) {
        this.valueOp = valueOp;
    }

    @Override
    public Boolean evaluate() {
        return valueOp.evaluate() == null;
    }

    @Override
    public String toString() {
        return "IS_NULL (" + valueOp + ')';
    }
}
