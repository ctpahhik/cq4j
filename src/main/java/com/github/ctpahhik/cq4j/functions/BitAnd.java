package com.github.ctpahhik.cq4j.functions;

public class BitAnd extends AbstractSimpleFunction<Long> {

    @Override
    public String getName() {
        return "BITAND";
    }

    @Override
    public Long evaluate() {
        Object first = parameters.get(0).evaluate();
        if (first == null) {
            return null;
        }
        Object second = parameters.get(1).evaluate();
        if (second == null) {
            return null;
        }
        return getLong(first) & getLong(first);
    }
}