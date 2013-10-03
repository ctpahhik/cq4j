package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class UnaryOperator extends AbstractOperator {

    public enum Type {
        MINUS
    }

    private IOperator valueOp;
    private Type type;

    public UnaryOperator(IOperator valueOp, Type type) {
        this.valueOp = valueOp;
        this.type = type;
    }

    @Override
    public Object evaluate(Object data) {
        Object value = valueOp.evaluate(data);
        if (value == null) {
            return null;
        }

        switch (type) {
            case MINUS: return convertToBigDecimal(value).negate();
        }

        throw new IllegalArgumentException("Unknown operation: " + type);
    }

    @Override
    public String toString() {
        return type + " (" + valueOp + ')';
    }
}
