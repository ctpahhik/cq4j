package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public abstract class AbstractOperator<T> implements IOperator<T> {

    @Override
    public abstract boolean isDeterministic();

    public static long getLong(Object param) {
        if (param instanceof BigDecimal) {
            try {
                return ((BigDecimal)param).longValueExact();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't get long: '"+param+"'");
            }
        } else  if (param instanceof java.lang.Number) {
            return ((Number)param).longValue(); //TODO: fix it for BigInteger
        } else if (param instanceof String) {
            try {
                BigDecimal d = new BigDecimal((String)param);
                return d.longValueExact();
            } catch (Exception e) {
                throw new IllegalArgumentException("Cant parse long: '"+param+"'");
            }
        }
        throw new IllegalArgumentException("Not Long: "+(param != null ? param.getClass() : "null"));
    }

    @SuppressWarnings("unchecked")
    public static Integer cmp(Object first, Object second) {
        if (first == null) {
            return null;
        }
        if (second == null) {
            return null;
        }
        if (first.equals(second)) {
            return 0;
        }
        if (first instanceof Comparable) {
            return ((Comparable) first).compareTo(second);
        }
        return null;
    }

    protected BigDecimal convertToBigDecimal(Object value) {
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        } else if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger) value);
        } else if (value instanceof Float || value instanceof Double) {
            return BigDecimal.valueOf(((Number)value).doubleValue());
        } else if (value instanceof Number) {
            return BigDecimal.valueOf(((Number)value).longValue());
        } else if (value instanceof String) {
            return new BigDecimal((String)value);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + value.getClass().getSimpleName());
        }
    }
}
