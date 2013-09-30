package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.data.AtomicReferenceArrayDataAdapter;
import com.github.ctpahhik.cq4j.data.BeanReflectionDataAdapter;
import com.github.ctpahhik.cq4j.performance.TestBean;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceArray;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class BeanReflectionDataProviderFunctionalTest {
    @Test
    public void testVariableTrueCondition() throws Exception {
        String qry = "param = 3";
        Evaluator expr = new Evaluator(qry, new BeanReflectionDataAdapter<TestBean>(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testVariableFalseCondition() throws Exception {
        String qry = "param = 3";
        Evaluator expr = new Evaluator(qry, new BeanReflectionDataAdapter<TestBean>(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(5);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testNvlCondition() throws Exception {
        String qry = "nvl(param1, param2, param) = 3";
        Evaluator expr = new Evaluator(qry, new BeanReflectionDataAdapter<TestBean>(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testSearchedCaseTrueCondition() throws Exception {
        String qry = "case param when 3 then true else false end";
        Evaluator expr = new Evaluator(qry, new BeanReflectionDataAdapter<TestBean>(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
        values.setParam(5);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testSearchedCaseCondition() throws Exception {
        String qry = "case param when 3 then true when 5 then false end";
        Evaluator expr = new Evaluator(qry, new BeanReflectionDataAdapter<TestBean>(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
        values.setParam(5);
        assertFalse(expr.isTrue(values));
        values.setParam(7);
        assertNull(expr.isTrue(values));
    }

    @Test
    public void testSimpleCaseTrueCondition() throws Exception {
        String qry = "case when param = 5 then true else false end";
        Evaluator expr = new Evaluator(qry, new BeanReflectionDataAdapter<TestBean>(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(5);
        assertTrue(expr.isTrue(values));
        values.setParam(7);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testSimpleCaseCondition() throws Exception {
        String qry = "case when param = 3 then true when param < 3 then false end";
        Evaluator expr = new Evaluator(qry, new BeanReflectionDataAdapter<TestBean>(TestBean.class));
        TestBean values = new TestBean();
        values.setParam(3);
        assertTrue(expr.isTrue(values));
        values.setParam(1);
        assertFalse(expr.isTrue(values));
        values.setParam(7);
        assertNull(expr.isTrue(values));
    }
}
