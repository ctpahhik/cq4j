package com.github.ctpahhik.cq4j.functions;

import java.util.Arrays;
import java.util.Collection;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class PositionArray extends AbstractInFunction<Integer> {

    @Override
    public String getName() {
        return "POSITION_ARRAY";
    }

    @Override
    public Integer evaluate() {
        Object value = valueOp.evaluate();
        if (value == null) {
            return null;
        }
        Object inValue = inValueOp.evaluate();
        if (inValue == null) {
            return null;
        }
        int from  = (fromOp == null) ? 0 : fromOp.evaluate();
        return positionArray(value, inValue, from);
    }

    private Integer positionArray(Object first, Object second, int from) {
        //TODO: implement properly
        if (second.getClass().isArray()) {
            second = Arrays.asList((Object[]) second);
        }
        return ((Collection) second).contains(first) ? 1 : 0;
    }
}
