package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.performance.TestBean;
import org.junit.Test;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class QueryFunctionalTest {

    @Test
    public void testSimple() throws Exception {
        String queryStr = "select *, b as c from testBean where 1=1 order by 3";
        Query<TestBean> query = new Query<TestBean>(queryStr, TestBean.class);
        System.out.println("query = " + query);
    }
}
