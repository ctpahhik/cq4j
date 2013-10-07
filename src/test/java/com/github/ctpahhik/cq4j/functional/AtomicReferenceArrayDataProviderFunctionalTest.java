package com.github.ctpahhik.cq4j.functional;

import com.github.ctpahhik.cq4j.Query;
import com.github.ctpahhik.cq4j.data.AtomicReferenceArrayDataAdapter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
public class AtomicReferenceArrayDataProviderFunctionalTest {

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
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Query expr = new Query(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testVariableFalseCondition() throws Exception {
        String qry = "param = 3";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Query expr = new Query(qry, new AtomicReferenceArrayDataAdapter(mapping));
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
        Query expr = new Query(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(3);
        values.set(0, 3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testSearchedCaseTrueCondition() throws Exception {
        String qry = "case param when 3 then true else false end";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Query expr = new Query(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 3);
        assertTrue(expr.isTrue(values));
    }

    @Test
    public void testSearchedCaseCondition() throws Exception {
        String qry = "case param when 3 then true when 5 then false end";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Query expr = new Query(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 3);
        assertTrue(expr.isTrue(values));
        values.set(0, 5);
        assertFalse(expr.isTrue(values));
        values.set(0, 7);
        assertNull(expr.evaluate(values));
    }

    @Test
    public void testSimpleCaseTrueCondition() throws Exception {
        String qry = "case when param = 5 then true when 3 = 5 then true else false end";
        Map<String,Integer> mapping = new HashMap<String, Integer>();
        mapping.put("param", 0);
        Query expr = new Query(qry, new AtomicReferenceArrayDataAdapter(mapping));
        AtomicReferenceArray<Object> values = new AtomicReferenceArray<Object>(1);
        values.set(0, 5);
        assertTrue(expr.isTrue(values));
    }
}
