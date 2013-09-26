package com.github.ctpahhik.cq4j.functions;

import com.github.ctpahhik.cq4j.common.IInFunction;
import com.github.ctpahhik.cq4j.common.IOperation;
import com.github.ctpahhik.cq4j.operations.AbstractOperation;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public abstract class AbstractInFunction<T> extends AbstractOperation<T> implements IInFunction<T>, Cloneable {

    protected IOperation valueOp;
    protected IOperation inValueOp;
    protected IOperation<Integer> fromOp;

    @Override
    @SuppressWarnings("unchecked")
    public IInFunction create(IOperation valueOp, IOperation inValueOp, IOperation<Integer> fromOp) {
        try {
            AbstractInFunction<T> function = (AbstractInFunction<T>) this.clone();
            function.setParameters(valueOp, inValueOp, fromOp);
            return function;
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("Function must be cloneable");
        }
    }

    private void setParameters(IOperation valueOp, IOperation inValueOp, IOperation<Integer> fromOp) {
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
