package com.github.ctpahhik.cq4j;

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
        Query.setDebug(true);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Query.setDebug(false);
    }

    @Test
    public void testConstantTrue() throws Exception {
        String qry = "true";
        Query<Object> expr = new Query<Object>(qry);
        assertTrue(expr.isTrue(null));
    }

    @Test
    public void testConstantFalse() throws Exception {
        String qry = "false";
        Query<Object> expr = new Query<Object>(qry);
        assertFalse(expr.isTrue(null));
    }

    @Test
    public void testSimpleTrueCondition() throws Exception {
        String qry = "1=1";
        Query<Object> expr = new Query<Object>(qry);
        assertTrue(expr.isTrue(null));
    }

    @Test
    public void testSimpleFalseCondition() throws Exception {
        String qry = "1>1";
        Query<Object> expr = new Query<Object>(qry);
        assertFalse(expr.isTrue(null));
    }
}
