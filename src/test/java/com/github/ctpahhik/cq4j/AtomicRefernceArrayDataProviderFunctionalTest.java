package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.data.AtomicReferenceArrayDataAdapter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceArray;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class AtomicRefernceArrayDataProviderFunctionalTest {
    @Test
    public void testVariableTrueCondition() throws Exception {
        String qry = "param = 3";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Evaluator expr = new Evaluator(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testVariableFalseCondition() throws Exception {
        String qry = "param = 3";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Evaluator expr = new Evaluator(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 5);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testNvlCondition() throws Exception {
        String qry = "nvl(param1, param2, param) = 3";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        mapping.put("param1", 1);
        mapping.put("param2", 2);
        Evaluator expr = new Evaluator(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(3);
        values.set(0, 3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testSearchedCaseTrueCondition() throws Exception {
        String qry = "case param when 3 then true else false end";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Evaluator expr = new Evaluator(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 3);
        assertFalse(expr.isTrue(values));
    }

    @Test
    public void testSimpleCaseTrueCondition() throws Exception {
        String qry = "case when param = 5 then true else false end";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Evaluator expr = new Evaluator(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 5);
        assertFalse(expr.isTrue(values));
    }
}
