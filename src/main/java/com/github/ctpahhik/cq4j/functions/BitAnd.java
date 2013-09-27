package com.github.ctpahhik.cq4j.functions;

public class BitAnd extends AbstractSimpleFunction<Long> {

    @Override
    public String getName() {
        return "BITAND";
    }

    @Override
    public Long evaluate(Object data) {
        Object first = parameters.get(0).evaluate(data);
        if (first == null) {
            return null;
        }
        Object second = parameters.get(1).evaluate(data);
        if (second == null) {
            return null;
        }
        return getLong(first) & getLong(first);
    }
}