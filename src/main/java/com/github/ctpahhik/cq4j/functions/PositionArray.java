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
    public Integer evaluate(Object data) {
        Object value = valueOp.evaluate(data);
        if (value == null) {
            return null;
        }
        Object inValue = inValueOp.evaluate(data);
        if (inValue == null) {
            return null;
        }
        int from  = fromOp.evaluate(data);
        return positionArray(value, inValue, from);
    }

    @Override
    protected Integer getDefaultFrom() {
        return 0;
    }

    private Integer positionArray(Object first, Object second, int from) {
        //TODO: implement properly
        if (second.getClass().isArray()) {
            second = Arrays.asList((Object[]) second);
        }
        return ((Collection) second).contains(first) ? 1 : 0;
    }
}
