package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * TODO: JavaDoc
 * Converts everything to BigDecimal and operates only with that type. //TODO: rewrite for different types for better performance
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ArithmeticOperator extends AbstractOperator {

    public enum Type {
        PLUS, MINUS, MULT, DIV, MOD
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
        Object leftVal = leftOp.evaluate(data);
        if (leftVal == null) {
            return null;
        }
        Object rightVal = rightOp.evaluate(data);
        if (rightVal == null) {
            return null;
        }
        BigDecimal left = convertToBigDecimal(leftVal);
        BigDecimal right = convertToBigDecimal(rightVal);

        switch (type) {
            case PLUS: return plus(left, right);
            case MINUS: return minus(left, right);
            case MULT: return mult(left, right);
            case DIV: return div(left, right);
            case MOD: return mod(left, right);
        }
        throw new IllegalArgumentException("Unknown operation: " + type);
    }



    private Object div(BigDecimal left, BigDecimal right) {
        return left.divide(right);
    }

    private Object mult(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }

    private Object plus(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }

    private Object minus(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    private Object mod(BigDecimal left, BigDecimal right) {
        return left.remainder(right);
    }

    @Override
    public String toString() {
        return "(" + leftOp + ") " + type + " (" + rightOp + ')';
    }


}
