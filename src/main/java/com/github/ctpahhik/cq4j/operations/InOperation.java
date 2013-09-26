package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

import java.util.List;

/**
 *
 * Boolean AND operation.
 * Violates 3VL Kleene logic for better laziness as it's enough for now.
 *
 * author: Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class InOperation extends AbstractOperation<Boolean> {

    private IOperation valueOp;
    private List<IOperation> listOp;

    public InOperation(IOperation valueOp, List<IOperation> listOp) {
        this.valueOp = valueOp;
        this.listOp = listOp;
    }

    @Override
    public Boolean evaluate() {
        Object value = valueOp.evaluate();
        if (value == null) {
            return null;
        }
        boolean hasNull = false;
        Object element;
        for (IOperation operation : listOp) {
            element = operation.evaluate();
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
