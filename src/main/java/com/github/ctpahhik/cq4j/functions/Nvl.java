package com.github.ctpahhik.cq4j.functions;

import com.github.ctpahhik.cq4j.common.IOperator;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class Nvl extends AbstractSimpleFunction<Object> {

    @Override
    public String getName() {
        return "NVL";
    }

    @Override
    public Object evaluate() {
        for (IOperator op : parameters) {
            Object value = op.evaluate();
            if (value != null) {
                return value;
            }
        }
        return null;
    }
}
