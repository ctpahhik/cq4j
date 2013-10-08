package com.github.ctpahhik.cq4j.functional;

import com.github.ctpahhik.cq4j.Query;
import com.github.ctpahhik.cq4j.performance.TestBean;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Verifications;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class QueryFunctionalTest {

    private TestBean bean1;
    private TestBean bean2;
    private TestBean bean3;
    @Injectable TestBean mock;
    private List<TestBean> data = new ArrayList<TestBean>();

    @Before
    public void setUp() throws Exception {
        bean1 = new TestBean(1, 2, 3, 4);
        data.add(bean1);
        data.add(new TestBean(1, 2, 3, 4));
        data.add(new TestBean(1, 2, 3, 4));
        data.add(new TestBean(1, 2, 3, 4));
        bean2 = new TestBean(2, 2, 3, 4);
        data.add(bean2);
        data.add(new TestBean(2, 2, 3, 4));
        data.add(new TestBean(2, 2, 3, 4));
        data.add(new TestBean(2, 2, 3, 4));
        bean3 = new TestBean(1, 5, 3, 4);
        data.add(bean3);
        data.add(new TestBean(1, 5, 3, 4));

        Query.setDebug(true);
        Query.setForkJoinSupported(false);
    }

    @After
    public void tearDown() throws Exception {
        data.clear();
    }

    @Test
    public void testFilterAll() throws Exception {
        Query<TestBean> query = new Query<TestBean>("1=1", TestBean.class);
        Collection<TestBean> result = query.filter(data);
        assertEquals(data, result);
    }

    @Test
    public void testFilterEquals() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param=1", TestBean.class);
        Collection<TestBean> result = query.filter(data);
        assertNotEquals(data, result);
        assertEquals(6, result.size());
        assertTrue(result.contains(bean1));
        assertFalse(result.contains(bean2));
        assertTrue(result.contains(bean3));
    }

    @Test
    public void testFilterGT() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param > 1", TestBean.class);
        Collection<TestBean> result = query.filter(data);
        assertNotEquals(data, result);
        assertEquals(4, result.size());
        assertFalse(result.contains(bean1));
        assertTrue(result.contains(bean2));
        assertFalse(result.contains(bean3));
    }

    @Test
    public void testFilterTwoFields() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param1 >=5 and param = 1", TestBean.class);
        Collection<TestBean> result = query.filter(data);
        assertNotEquals(data, result);
        assertEquals(2, result.size());
        assertFalse(result.contains(bean1));
        assertFalse(result.contains(bean2));
        assertTrue(result.contains(bean3));
    }

    @Test
    public void testFilterParallelAll() throws Exception {
        Query<TestBean> query = new Query<TestBean>("1=1", TestBean.class);
        Collection<TestBean> result = query.filterParallel(data);
        assertEquals(data, result);
    }

    @Test
    public void testFilterParallelEquals() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param=1", TestBean.class);
        Collection<TestBean> result = query.filterParallel(data);
        assertNotEquals(data, result);
        assertEquals(6, result.size());
        assertTrue(result.contains(bean1));
        assertFalse(result.contains(bean2));
        assertTrue(result.contains(bean3));
    }

    @Test
    public void testFilterParallelGT() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param > 1", TestBean.class);
        Collection<TestBean> result = query.filterParallel(data);
        assertNotEquals(data, result);
        assertEquals(4, result.size());
        assertFalse(result.contains(bean1));
        assertTrue(result.contains(bean2));
        assertFalse(result.contains(bean3));
    }

    @Test
    public void testFilterParallelTwoFields() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param1 >=5 and param = 1", TestBean.class);
        Collection<TestBean> result = query.filterParallel(data);
        assertNotEquals(data, result);
        assertEquals(2, result.size());
        assertFalse(result.contains(bean1));
        assertFalse(result.contains(bean2));
        assertTrue(result.contains(bean3));
    }

    @Test
    public void testIteratorAll() throws Exception {
        Query<TestBean> query = new Query<TestBean>("1=1", TestBean.class);
        Collection<TestBean> result = new ArrayList<TestBean>();
        for (TestBean bean : query.getIterable(data)) {
            result.add(bean);
        }
        assertEquals(data, result);
    }

    @Test
    public void testIteratorEquals() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param=1", TestBean.class);
        Collection<TestBean> result = new ArrayList<TestBean>();
        for (TestBean bean : query.getIterable(data)) {
            result.add(bean);
        }
        assertNotEquals(data, result);
        assertEquals(6, result.size());
        assertTrue(result.contains(bean1));
        assertFalse(result.contains(bean2));
        assertTrue(result.contains(bean3));
    }

    @Test
    public void testIteratorGT() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param > 1", TestBean.class);
        Collection<TestBean> result = new ArrayList<TestBean>();
        for (TestBean bean : query.getIterable(data)) {
            result.add(bean);
        }
        assertNotEquals(data, result);
        assertEquals(4, result.size());
        assertFalse(result.contains(bean1));
        assertTrue(result.contains(bean2));
        assertFalse(result.contains(bean3));
    }

    @Test
    public void testIteratorTwoFields() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param1 >=5 and param = 1", TestBean.class);
        Collection<TestBean> result = new ArrayList<TestBean>();
        for (TestBean bean : query.getIterable(data)) {
            result.add(bean);
        }
        assertNotEquals(data, result);
        assertEquals(2, result.size());
        assertFalse(result.contains(bean1));
        assertFalse(result.contains(bean2));
        assertTrue(result.contains(bean3));
    }

    @Test
    public void testIteratorLazy() throws Exception {
        Query<TestBean> query = new Query<TestBean>("param1 >=5 and param = 1", TestBean.class);
        data.add(mock);
        Iterator<TestBean> result = query.getIterable(data).iterator();
        result.next();
        new Verifications() {
            {
                mock.getParam1(); maxTimes=0;
            }
        };
        while (result.hasNext()) {
            result.next();
        }
        new Verifications() {
            {
                mock.getParam1(); maxTimes=1;
            }
        };
    }
}
