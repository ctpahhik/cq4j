package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class UnaryOperation extends AbstractOperation {

    public enum Type {
        MINUS
    }

    private IOperation valueOp;
    private Type type;

    public UnaryOperation(IOperation valueOp, Type type) {
        this.valueOp = valueOp;
        this.type = type;
    }

    @Override
    public Object evaluate() {
        return null;  //TODO: Implement
    }

    @Override
    public String toString() {
        return type + " (" + valueOp + ')';
    }
}
