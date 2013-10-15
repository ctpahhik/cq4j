package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.performance.TestBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class QueryFunctionalTest {

    @Test
    public void testParsing() throws Exception {
        String queryStr = "select *, b as c from testBean where 1=1 order by 3";
        SingleTypeQuery<TestBean> query = new SingleTypeQuery<TestBean>(queryStr, TestBean.class);
        System.out.println("query = " + query);
    }

    @Test
    public void testParsingMultitable() throws Exception {
        String queryStr = "select *, b as c from testBean where 1=1 and testbean.param>0 order by 3";
        SingleTypeQuery<TestBean> query = new SingleTypeQuery<TestBean>(queryStr, TestBean.class);
        System.out.println("query = " + query);
    }

    @Test
    public void testSimple() throws Exception {
        String queryStr = "select *, b as c from testBean where param1>1 and param between 0 and 10 order by param, param2";
        SingleTypeQuery<TestBean> query = new SingleTypeQuery<TestBean>(queryStr, TestBean.class);
        System.out.println("query = " + query);

        TestBean bean1 = new TestBean(5, 4, 3, 2);
        TestBean bean2 = new TestBean(4, 4, 3, 2);
        TestBean bean3 = new TestBean(6, 4, 3, 2);
        TestBean bean4 = new TestBean(0, 0, 3, 2);
        TestBean bean5 = new TestBean(1, 4, 3, 2);
        TestBean bean6 = new TestBean(6, 4, 2, 2);
        TestBean bean7 = new TestBean(6, 4, 1, 2);

        List<TestBean> source = new ArrayList<TestBean>();
        source.add(bean1);
        source.add(bean2);
        source.add(bean3);
        source.add(bean4);
        source.add(bean5);
        source.add(bean6);
        source.add(bean7);

        List<TestBean> expected = new ArrayList<TestBean>();
        expected.add(bean5);
        expected.add(bean2);
        expected.add(bean1);
        expected.add(bean7);
        expected.add(bean6);
        expected.add(bean3);

        List<TestBean> result = new ArrayList<TestBean>();
        for (Object[] bean : query.execute(source)) {
            result.add((TestBean) bean[0]);
        }
        assertEquals(expected, result);
    }
}
