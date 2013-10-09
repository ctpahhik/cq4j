package com.github.ctpahhik.cq4j.functional;

import com.github.ctpahhik.cq4j.Filter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class NoDataProviderFunctionalTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        Filter.setDebug(true);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Filter.setDebug(false);
    }

    @Test
    public void testConstantTrue() throws Exception {
        String qry = "true";
        Filter<Object> expr = new Filter<Object>(qry);
        assertTrue(expr.isTrue(null));
    }

    @Test
    public void testConstantFalse() throws Exception {
        String qry = "false";
        Filter<Object> expr = new Filter<Object>(qry);
        assertFalse(expr.isTrue(null));
    }

    @Test
    public void testSimpleTrueCondition() throws Exception {
        String qry = "1=1";
        Filter<Object> expr = new Filter<Object>(qry);
        assertTrue(expr.isTrue(null));
    }

    @Test
    public void testSimpleFalseCondition() throws Exception {
        String qry = "1>1";
        Filter<Object> expr = new Filter<Object>(qry);
        assertFalse(expr.isTrue(null));
    }
}
