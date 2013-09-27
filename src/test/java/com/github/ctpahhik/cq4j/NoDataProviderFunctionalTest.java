package com.github.ctpahhik.cq4j;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class NoDataProviderFunctionalTest {

    @Test
    public void testConstantTrue() throws Exception {
        String qry = "true";
        Evaluator expr = new Evaluator(qry, null);
        assertTrue(expr.isTrue(null));
    }


    @Test
    public void testConstantFalse() throws Exception {
        String qry = "false";
        Evaluator expr = new Evaluator(qry, null);
        assertFalse(expr.isTrue(null));
    }

    @Test
    public void testSimpleTrueCondition() throws Exception {
        String qry = "1=1";
        Evaluator expr = new Evaluator(qry, null);
        assertTrue(expr.isTrue(null));
    }

    @Test
    public void testSimpleFalseCondition() throws Exception {
        String qry = "1>1";
        Evaluator expr = new Evaluator(qry, null);
        assertFalse(expr.isTrue(null));
    }
}
