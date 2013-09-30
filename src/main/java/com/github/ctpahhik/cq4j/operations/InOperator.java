package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.util.List;

/**
 *
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class InOperator extends AbstractOperator<Boolean> {

    private IOperator valueOp;
    private List<IOperator> listOp;

    public InOperator(IOperator valueOp, List<IOperator> listOp) {
        this.valueOp = valueOp;
        this.listOp = listOp;
    }

    @Override
    public Boolean evaluate(Object data) {
        Object value = valueOp.evaluate(data);
        if (value == null) {
            return null;
        }
        boolean hasNull = false;
        Object element;
        for (IOperator operation : listOp) {
            element = operation.evaluate(data);
            if (element == null) {
                hasNull = true;
            } else if (value.equals(element)) {
                return true;
            }
        }

        return hasNull ? null : false;
    }

    @Override
    public String toString() {
        return "(" + valueOp + ") IN (" + listOp + ')';
    }
}
