package com.github.ctpahhik.cq4j.performance;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ReflectionPerformanceTest {

    private final static int testDataSize = 1000000;
    private final static int warmUpIterations = 10;
    private final static int runIterations = 10;
    private TestBean[] testData = new TestBean[testDataSize];
    private Method[] methods = new Method[4];
    private Field[] fields = new Field[4];
    private Random rnd = new Random();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i<testDataSize; i++) {
            testData[i] = new TestBean();
            testData[i].setA(rnd.nextInt());
            testData[i].setB(String.valueOf(rnd.nextLong()));
            testData[i].setC(rnd.nextInt());
            testData[i].setD(rnd.nextBoolean() ? new TestBean() : null);
        }

        methods[0] = TestBean.class.getMethod("getA");
        methods[1] = TestBean.class.getMethod("getB");
        methods[2] = TestBean.class.getMethod("getC");
        methods[3] = TestBean.class.getMethod("getD");

        fields[0] = TestBean.class.getDeclaredField("a");
        fields[0].setAccessible(true);
        fields[1] = TestBean.class.getDeclaredField("b");
        fields[1].setAccessible(true);
        fields[2] = TestBean.class.getDeclaredField("c");
        fields[2].setAccessible(true);
        fields[3] = TestBean.class.getDeclaredField("d");
        fields[3].setAccessible(true);
    }

    @Test
    public void testAccessor() throws Exception {
        System.out.println("testAccessor");
        long start = System.nanoTime();

        long wr = 0;

        for (int i=0; i<warmUpIterations; i++) {
            wr += getByMethods();
            testData[i] = new TestBean();
            testData[i].setA(rnd.nextInt());
            testData[i].setB(String.valueOf(rnd.nextLong()));
            testData[i].setC(rnd.nextInt());
        }
        System.out.println("wr = " + wr);
        System.out.println("Warm Up Time=" + (float)(System.nanoTime()-start)/1000000000);

        long result = 0;
        for (int i=0; i<runIterations; i++) {
            start = System.nanoTime();
            result = getByMethods();
            System.out.println("Time=" + (float)(System.nanoTime()-start)/1000000000);
            System.out.println("result = " + result);
        }

    }

    @Test
    public void testFields() throws Exception {
        System.out.println("testFields");
        long start = System.nanoTime();

        long wr = 0;

        for (int i=0; i<warmUpIterations; i++) {
            wr += getByFields();
            testData[i] = new TestBean();
            testData[i].setA(rnd.nextInt());
            testData[i].setB(String.valueOf(rnd.nextLong()));
            testData[i].setC(rnd.nextInt());
        }
        System.out.println("wr = " + wr);
        System.out.println("Warm Up Time=" + (float)(System.nanoTime()-start)/1000000000);

        long result = 0;
        for (int i=0; i<runIterations; i++) {
            start = System.nanoTime();
            result = getByFields();
            System.out.println("Time=" + (float)(System.nanoTime()-start)/1000000000);
            System.out.println("result = " + result);
        }

    }

    @Test
    public void testMixed() throws Exception {
        System.out.println("testMixed");
        long start = System.nanoTime();

        long wr = 0;

        for (int i=0; i<warmUpIterations; i++) {
            wr += getByMixed();
            testData[i] = new TestBean();
            testData[i].setA(rnd.nextInt());
            testData[i].setB(String.valueOf(rnd.nextLong()));
            testData[i].setC(rnd.nextInt());
        }
        System.out.println("wr = " + wr);
        System.out.println("Warm Up Time=" + (float)(System.nanoTime()-start)/1000000000);

        Field tmp1 = fields[1];
        fields[1] = null;
        Field tmp3 = fields[3];
        fields[3] = null;

        long result = 0;
        for (int i=0; i<runIterations; i++) {
            start = System.nanoTime();
            result = getByMixed();
            System.out.println("Time=" + (float)(System.nanoTime()-start)/1000000000);
            System.out.println("result = " + result);
        }

        fields[1] = tmp1;
        fields[3] = tmp3;
    }

    public long getByMethods() throws Exception {
        long result = 0;

        for (TestBean bean : testData) {
            result += (Integer)methods[0].invoke(bean);
            result += ((String)methods[1].invoke(bean)).length();
            result += (Integer)methods[2].invoke(bean);
            result += (methods[3].invoke(bean) == null) ? 1 : 0;
        }

        return result;
    }

    public long getByFields() throws Exception {
        long result = 0;

        for (TestBean bean : testData) {
            result += (Integer)fields[0].get(bean);
            result += ((String)fields[1].get(bean)).length();
            result += (Integer)fields[2].get(bean);
            result += (fields[3].get(bean) == null) ? 1 : 0;
        }

        return result;
    }

    public long getByMixed() throws Exception {
        long result = 0;

        for (TestBean bean : testData) {
            for (int i=0; i<4; i++) {
                switch (i) {
                    case 0:
                        if (fields[0] != null) {
                            result += (Integer)fields[0].get(bean);
                        } else {
                            result += (Integer)methods[0].invoke(bean);
                        }
                        break;
                    case 1:
                        if (fields[1] != null) {
                            result += ((String)fields[1].get(bean)).length();
                        } else {
                            result += ((String)methods[1].invoke(bean)).length();
                        }
                        break;
                    case 2:
                        if (fields[2] != null) {
                            result += (Integer)fields[2].get(bean);
                        } else {
                            result += (Integer)methods[2].invoke(bean);
                        }
                        break;
                    case 3:
                        if (fields[3] != null) {
                            result += (fields[3].get(bean) == null) ? 1 : 0;
                        } else {
                            result += (methods[3].invoke(bean) == null) ? 1 : 0;
                        }
                        break;
                }
            }
        }

        return result;
    }
}
