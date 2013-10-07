package com.github.ctpahhik.cq4j.functions;

import com.github.ctpahhik.cq4j.common.IInFunction;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.operations.AbstractOperator;
import com.github.ctpahhik.cq4j.operations.ConstantOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public abstract class AbstractInFunction<T> extends AbstractOperator<T> implements IInFunction<T> {

    protected IOperator valueOp;
    protected IOperator inValueOp;
    protected IOperator<Integer> fromOp;
    protected boolean hasFrom = false;

    void setParameters(IOperator valueOp, IOperator inValueOp, IOperator<Integer> fromOp) {
        this.valueOp = valueOp;
        this.inValueOp = inValueOp;

        hasFrom = (fromOp != null);
        this.fromOp = fromOp == null ? new ConstantOperator<Integer>(getDefaultFrom()) : fromOp;
    }

    protected abstract Integer getDefaultFrom();

    @Override
    public boolean isDeterministic() {
        return valueOp.isDeterministic() && inValueOp.isDeterministic() && fromOp.isDeterministic();
    }

    @Override
    public String toString() {
        return getName() + " (" +
                valueOp +
                ") IN (" + inValueOp + ")" +
                (hasFrom ? " FROM (" + fromOp + ")" : "");
    }
}
