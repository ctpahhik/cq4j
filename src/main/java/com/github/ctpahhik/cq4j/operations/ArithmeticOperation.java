package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ArithmeticOperation extends AbstractOperation {

    public enum Type {
        PLUS, MINUS, MULT, DIV
    }

    private IOperation leftOp;
    private IOperation rightOp;
    private Type type;

    public ArithmeticOperation(IOperation leftOp, IOperation rightOp, Type type) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
        this.type = type;
    }

    @Override
    public Object evaluate() {
        return null; //TODO: implement
    }

    @Override
    public String toString() {
        return "(" + leftOp + ") " + type + " (" + rightOp + ')';
    }
}
