package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class CompareOperator extends AbstractOperator<Boolean> {

    public enum Type {
        EQ, NOT_EQ, LT, LT_EQ, GT, GT_EQ
    }

    private IOperator<Comparable> leftOp;
    private IOperator<Comparable> rightOp;
    private Type type;

    public CompareOperator(IOperator<Comparable> leftOp, IOperator<Comparable> rightOp, Type type) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
        this.type = type;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Boolean evaluate() {
        Comparable left = leftOp.evaluate();
        if (left == null) {
            return null;
        }
        Comparable right = rightOp.evaluate();
        if (right == null) {
            return null;
        }

        int val = left.compareTo(right);
        switch (type) {
            case EQ: return val == 0;
            case NOT_EQ: return val != 0;
            case LT: return val < 0;
            case LT_EQ: return val <= 0;
            case GT: return val > 0;
            case GT_EQ: return val >= 0;
            default:
                throw new java.lang.IllegalArgumentException("Unknown comparison type: " + type);
        }
    }

    @Override
    public String toString() {
        return "(" + leftOp + ") " + type + " (" + rightOp + ')';
    }
}
