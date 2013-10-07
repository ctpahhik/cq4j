package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class NotOperator extends AbstractOperator<Boolean> {

    private IOperator<Boolean> valueOp;

    public NotOperator(IOperator<Boolean> valueOp) {
        this.valueOp = valueOp;
    }

    @Override
    public Boolean evaluate(Object data) {
        Boolean value = valueOp.evaluate(data);
        return value == null ? null : !value ;
    }

    @Override
    public boolean isDeterministic() {
        return valueOp.isDeterministic();
    }

    @Override
    public String toString() {
        return "NOT (" + valueOp + ')';
    }
}
