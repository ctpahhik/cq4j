package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ArithmeticOperatorTest {

    @Test
    public void testPlus() throws Exception {
        IOperator left = new ConstantOperator(1);
        IOperator right = new ConstantOperator(1);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(2), actual.evaluate(null));
    }

    @Test
    public void testPlusInt() throws Exception {
        IOperator left = new ConstantOperator(42);
        IOperator right = new ConstantOperator(76);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(118), actual.evaluate(null));
        assertEquals(BigDecimal.valueOf(118L), actual.evaluate(null));
    }

    @Test
    public void testPlusLong() throws Exception {
        IOperator left = new ConstantOperator(123456789012L);
        IOperator right = new ConstantOperator(345678901234L);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(123456789012L).add(BigDecimal.valueOf(345678901234L)), actual.evaluate(null));
    }

    @Test
    public void testPlusBigLong() throws Exception {
        IOperator left = new ConstantOperator(Long.MAX_VALUE);
        IOperator right = new ConstantOperator(Long.MIN_VALUE);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.valueOf(Long.MIN_VALUE)), actual.evaluate(null));
    }

    @Test
    public void testPlusString() throws Exception {
        IOperator left = new ConstantOperator("123");
        IOperator right = new ConstantOperator("98");
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(221), actual.evaluate(null));
    }

    @Test
    public void testPlusBigString() throws Exception {
        IOperator left = new ConstantOperator("1234875928374509823461968459815917498721987349879384701353");
        IOperator right = new ConstantOperator("99340859587609345876903845769385769837459689348");
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(new BigDecimal("1234875928374509823461968459815917498721987349879384701353").add(new BigDecimal("99340859587609345876903845769385769837459689348")), actual.evaluate(null));
    }

    @Test
    public void testPlusBigInt() throws Exception {
        IOperator left = new ConstantOperator(Integer.MAX_VALUE);
        IOperator right = new ConstantOperator(Integer.MIN_VALUE);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(Integer.MAX_VALUE).add(BigDecimal.valueOf(Integer.MIN_VALUE)), actual.evaluate(null));
    }

    @Test
    public void testPlusFloat() throws Exception {
        IOperator left = new ConstantOperator(12.36);
        IOperator right = new ConstantOperator(33.67);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(46.03), actual.evaluate(null));
    }

    @Test
    public void testPlusDouble() throws Exception {
        IOperator left = new ConstantOperator(1234567890123.55d);
        IOperator right = new ConstantOperator(345678901234.88d);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(1234567890123.55d).add(BigDecimal.valueOf(345678901234.88d)), actual.evaluate(null));
    }

    @Test
    public void testPlusBigDecimal() throws Exception {
        IOperator left = new ConstantOperator(BigDecimal.valueOf(45797238956457.123740d));
        IOperator right = new ConstantOperator(8867359.749283d);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.PLUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(45797238956457.123740d).add(BigDecimal.valueOf(8867359.749283d)), actual.evaluate(null));
    }

    @Test
    public void testMinus() throws Exception {
        IOperator left = new ConstantOperator(1);
        IOperator right = new ConstantOperator(1);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.MINUS;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(0), actual.evaluate(null));
    }

    @Test
    public void testMult() throws Exception {
        IOperator left = new ConstantOperator(1);
        IOperator right = new ConstantOperator(1);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.MULT;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(1), actual.evaluate(null));
    }

    @Test
    public void testDiv() throws Exception {
        IOperator left = new ConstantOperator(1);
        IOperator right = new ConstantOperator(1);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.DIV;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(1), actual.evaluate(null));
    }

    @Test
    public void testMod() throws Exception {
        IOperator left = new ConstantOperator(1);
        IOperator right = new ConstantOperator(1);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.MOD;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(0), actual.evaluate(null));
    }

    @Test
    public void testModWithReminder() throws Exception {
        IOperator left = new ConstantOperator(13);
        IOperator right = new ConstantOperator(2);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.MOD;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(1), actual.evaluate(null));
    }

    @Test
    public void testModNoReminder() throws Exception {
        IOperator left = new ConstantOperator(15);
        IOperator right = new ConstantOperator(3);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.MOD;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(0), actual.evaluate(null));
    }

    @Test
    public void testNull() throws Exception {
        IOperator left = new ConstantOperator(1);
        IOperator right = new ConstantOperator(null);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.DIV;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(null, actual.evaluate(null));

        actual = new ArithmeticOperator(right, left, type);

        assertEquals(null, actual.evaluate(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWrongLeftParameterType() throws Exception {
        IOperator left = new ConstantOperator(new Object());
        IOperator right = new ConstantOperator(1);
        ArithmeticOperator.Type type = ArithmeticOperator.Type.DIV;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(1), actual.evaluate(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWrongRightParameterType() throws Exception {
        IOperator left = new ConstantOperator(1);
        IOperator right = new ConstantOperator(new Object());
        ArithmeticOperator.Type type = ArithmeticOperator.Type.DIV;
        IOperator actual = new ArithmeticOperator(left, right, type);

        assertEquals(BigDecimal.valueOf(1), actual.evaluate(null));
    }
}
