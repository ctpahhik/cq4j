package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperation;

import java.math.BigDecimal;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public abstract class AbstractOperation<T> implements IOperation<T> {

    @Override
    public boolean isPureFunction() {
        return true;
    }

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
}
