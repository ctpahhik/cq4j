package com.github.ctpahhik.cq4j.functions;

import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.common.ISimpleFunction;
import com.github.ctpahhik.cq4j.operations.AbstractOperator;

import java.util.List;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public abstract class AbstractSimpleFunction<T> extends AbstractOperator<T> implements ISimpleFunction<T>, Cloneable {

    protected List<IOperator> parameters;

    void setParameters(List<IOperator> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean isDeterministic() {
        for (IOperator operator : parameters) {
            if (!operator.isDeterministic()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return getName() + " (" + parameters + ')';
    }
}
