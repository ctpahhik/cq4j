package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class NotOperation extends AbstractOperation<Boolean> {

    private IOperation<Boolean> valueOp;

    public NotOperation(IOperation<Boolean> valueOp) {
        this.valueOp = valueOp;
    }

    @Override
    public Boolean evaluate() {
        Boolean value = valueOp.evaluate();
        return value == null ? null : !value ;
    }

    @Override
    public String toString() {
        return "NOT (" + valueOp + ')';
    }
}
