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

    @Override
    @SuppressWarnings("unchecked")
    public ISimpleFunction create(List<IOperator> parameters) {
        try {
            AbstractSimpleFunction<T> function = (AbstractSimpleFunction<T>) this.clone();
            function.setParameters(parameters);
            return function;
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("Function must be cloneable");
        }
    }

    private void setParameters(List<IOperator> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return getName() + " (" + parameters + ')';
    }
}
