package com.github.ctpahhik.cq4j.performance;

import com.github.ctpahhik.cq4j.utils.SingleFileManager;
import com.github.ctpahhik.cq4j.utils.StringJavaFileObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.tools.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ReflectionPerformanceTest {

    private final static int testDataSize = 100000;
    private final static int warmUpIterations = 10;
    private final static int runIterations = 10;
    private static TestBean[] testData = new TestBean[testDataSize];
    private static Method[] methods = new Method[4];
    private static Field[] fields = new Field[4];
    private static Acc instance;
    private static Random rnd = new Random();

    @BeforeClass
    public static void setUp() throws Exception {
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

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StringBuilder builder = new StringBuilder("public class TestBean2 implements com.github.ctpahhik.cq4j.performance.Acc {\n");
        builder.append("private ").append(TestBean.class.getCanonicalName()).append(" value;\n");
        builder.append("public TestBean2() {}\n");
        builder.append("public TestBean2(").append(TestBean.class.getCanonicalName()).append(" value) {this.value = value;}\n");
        builder.append("public void setBean(Object value) {this.value = (").append(TestBean.class.getCanonicalName()).append(")value;}\n");
        builder.append("public Object getValue(int id) {\n");
        builder.append("switch (id) {\n");
        int id = 0;
        for (Method method : TestBean.class.getMethods()) {
            if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                builder.append("case ").append(id).append(":").append(" return value.").append(method.getName()).append("();\n");
                id++;
            }
        }
        builder.append("}\n");
        builder.append("return null;\n");
        builder.append("}\n");
        builder.append("}\n");

        JavaFileObject file = new StringJavaFileObject("TestBean2", builder.toString());

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        JavaFileManager fileManager = new
                SingleFileManager(compiler
                .getStandardFileManager(diagnostics, null, null));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);

        System.out.println(task.call());
        System.out.println("----");
        System.out.println(task);
        System.out.println("----");
        System.out.println(diagnostics.getDiagnostics());
        instance = (Acc) fileManager.getClassLoader(null).loadClass("TestBean2").getConstructor().newInstance();
        System.out.println("---------------------");
    }

    @Test
    public void testAccessor() throws Exception {
        execute("getByMethods");
    }

    @Test
    public void testFields() throws Exception {
        execute("getByFields");
    }

    @Test
    public void testMixed() throws Exception {
        execute("getByMixed");
    }

    @Test
    public void testDirect() throws Exception {
        execute("getByDirect");
    }

    @Test
    @Ignore //required java 7
    public void testInvokeDynamic() throws Throwable {
        execute("getByInvokeDynamic");
    }

    @Test
    public void testCodegen() throws Throwable {
        execute("getByCodegen");
    }

    private float execute(String methodName) throws Exception {
        System.out.println(methodName);
        long start = System.nanoTime();

        long wr = 0;

        Method method = this.getClass().getDeclaredMethod(methodName);

        for (int i=0; i<warmUpIterations; i++) {
            wr += (Long)method.invoke(this);
            testData[i] = new TestBean();
            testData[i].setA(rnd.nextInt());
            testData[i].setB(String.valueOf(rnd.nextLong()));
            testData[i].setC(rnd.nextInt());
        }
        System.out.println("wr = " + wr);
        System.out.println("Warm Up Time=" + (float)(System.nanoTime()-start)/1000000000);

        Field tmp1 = fields[1];
        Field tmp3 = fields[3];
        if (methodName.equals("getByMixed")) {
            fields[1] = null;
            fields[3] = null;
        }

        long result = 0;
        start = System.nanoTime();
        for (int i=0; i<runIterations; i++) {
            result += (Long)method.invoke(this);
        }
        float totalTime = System.nanoTime()-start;
        System.out.println("result = " + result);
        System.out.println("Time=" + totalTime/1000000000);

        fields[1] = tmp1;
        fields[3] = tmp3;

        System.out.println("----");
        return totalTime/runIterations;
    }

    private long getByMethods() throws Exception {
        long result = 0;

        for (TestBean bean : testData) {
            result += (Integer)methods[0].invoke(bean);
            result += ((String)methods[1].invoke(bean)).length();
            result += (Integer)methods[2].invoke(bean);
            result += (methods[3].invoke(bean) == null) ? 1 : 0;
        }

        return result;
    }

    private long getByFields() throws Exception {
        long result = 0;

        for (TestBean bean : testData) {
            result += (Integer)fields[0].get(bean);
            result += ((String)fields[1].get(bean)).length();
            result += (Integer)fields[2].get(bean);
            result += (fields[3].get(bean) == null) ? 1 : 0;
        }

        return result;
    }

    private long getByDirect() throws Exception {
        long result = 0;

        for (TestBean bean : testData) {
            result += bean.getA();
            result += bean.getB().length();
            result += bean.getC();
            result += (bean.getD() == null) ? 1 : 0;
        }

        return result;
    }

    private long getByInvokeDynamic() throws Throwable {
        long result = 0;

        TestBean tmp = new TestBean();
        tmp.setA(42);
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle a = lookup.unreflect(methods[0]).asType(MethodType.methodType(Integer.class, TestBean.class));
        MethodHandle b = lookup.unreflect(methods[1]);
        MethodHandle c = lookup.unreflect(methods[2]);
        MethodHandle d = lookup.unreflect(methods[3]);

        for (TestBean bean : testData) {
            result += (Integer)a.invokeExact(bean);
            result += ((String)b.invokeExact(bean)).length();
            result += (Integer)c.invokeExact(bean);
            result += (d.invokeExact(bean) == null) ? 1 : 0;
        }

        return result;
    }

    private long getByMixed() throws Exception {
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

    private long getByCodegen() throws Exception {
        long result = 0;

        for (TestBean bean : testData) {
            instance.setBean(bean);
            result += (Integer)instance.getValue(0);
            result += ((String)instance.getValue(1)).length();
            result += (Integer)instance.getValue(2);
            result += (instance.getValue(3) == null) ? 1 : 0;
        }

        return result;
    }
}
