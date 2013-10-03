package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IOperator;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class UnaryOperatorTest {

    @Test
    public void testEvaluate() throws Exception {
        IOperator value = new ConstantOperator(42);
        IOperator actual = new UnaryOperator(value, UnaryOperator.Type.MINUS);

        assertEquals(BigDecimal.valueOf(-42), actual.evaluate(null));
    }

    @Test
    public void testEvaluateBig() throws Exception {
        IOperator value = new ConstantOperator(Long.MIN_VALUE);
        IOperator actual = new UnaryOperator(value, UnaryOperator.Type.MINUS);

        assertEquals(BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE), actual.evaluate(null));
    }

    @Test
    public void testNull() throws Exception {
        IOperator value = new ConstantOperator(null);
        IOperator actual = new UnaryOperator(value, UnaryOperator.Type.MINUS);

        assertNull(actual.evaluate(null));
    }
}
