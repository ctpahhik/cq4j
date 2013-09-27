package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ArithmeticOperator extends AbstractOperator {

    public enum Type {
        PLUS, MINUS, MULT, DIV
    }

    private IOperator leftOp;
    private IOperator rightOp;
    private Type type;

    public ArithmeticOperator(IOperator leftOp, IOperator rightOp, Type type) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
        this.type = type;
    }

    @Override
    public Object evaluate(Object data) {
        return null; //TODO: implement
    }

    @Override
    public String toString() {
        return "(" + leftOp + ") " + type + " (" + rightOp + ')';
    }
}
