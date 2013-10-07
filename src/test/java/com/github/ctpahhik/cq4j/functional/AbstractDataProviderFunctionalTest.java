package com.github.ctpahhik.cq4j.functional;

import com.github.ctpahhik.cq4j.Query;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.performance.TestBean;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public abstract class AbstractDataProviderFunctionalTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        Query.setDebug(true);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Query.setDebug(false);
    }

    @Test
    public void testVariableTrueCondition() throws Exception {
        String qry = "param = 3";
        Query expr = new Query(qry, createDataAdapter(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testVariableFalseCondition() throws Exception {
        String qry = "param = 3";
        Query expr = new Query(qry, createDataAdapter(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(5);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testNvlCondition() throws Exception {
        String qry = "nvl(param1, param2, param) = 3";
        Query expr = new Query(qry, createDataAdapter(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testSearchedCaseTrueCondition() throws Exception {
        String qry = "case param when 3 then true else false end";
        Query expr = new Query(qry, createDataAdapter(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
        values.setParam(5);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testSearchedCaseCondition() throws Exception {
        String qry = "case param when 3 then true when 5 then false end";
        Query expr = new Query(qry, createDataAdapter(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
        values.setParam(5);
        assertFalse(expr.isTrue(values));
        values.setParam(7);
        assertNull(expr.evaluate(values));
    }

    @Test
    public void testSimpleCaseTrueCondition() throws Exception {
        String qry = "case when param = 5 then true else false end";
        Query expr = new Query(qry, createDataAdapter(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(5);
        assertTrue(expr.isTrue(values));
        values.setParam(7);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testSimpleCaseCondition() throws Exception {
        String qry = "case when param = 3 then true when param < 3 then false end";
        Query expr = new Query(qry, createDataAdapter(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
        values.setParam(1);
        assertFalse(expr.isTrue(values));
        values.setParam(7);
        assertNull(expr.evaluate(values));
    }

    protected abstract IDataAdapter createDataAdapter(Class clazz);
}
