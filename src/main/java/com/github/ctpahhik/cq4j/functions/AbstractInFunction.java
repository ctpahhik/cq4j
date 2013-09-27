package com.github.ctpahhik.cq4j.functions;

import com.github.ctpahhik.cq4j.common.IInFunction;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.operations.AbstractOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public abstract class AbstractInFunction<T> extends AbstractOperator<T> implements IInFunction<T>, Cloneable {

    protected IOperator valueOp;
    protected IOperator inValueOp;
    protected IOperator<Integer> fromOp;

    @Override
    @SuppressWarnings("unchecked")
    public IInFunction create(IOperator valueOp, IOperator inValueOp, IOperator<Integer> fromOp) {
        try {
            AbstractInFunction<T> function = (AbstractInFunction<T>) this.clone();
            function.setParameters(valueOp, inValueOp, fromOp);
            return function;
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("Function must be cloneable");
        }
    }

    private void setParameters(IOperator valueOp, IOperator inValueOp, IOperator<Integer> fromOp) {
        this.valueOp = valueOp;
        this.inValueOp = inValueOp;
        this.fromOp = fromOp;
    }

    @Override
    public String toString() {
        return getName() + " (" +
                valueOp +
                " IN " + inValueOp +
                (fromOp == null ? "" : " FROM " + fromOp) +
                ')';
    }
}
