package com.github.ctpahhik.cq4j.performance;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class TestBean {

    private int a;
    private String b;
    private Integer c;
    private Object d;
    private Object param;
    private Object param1;
    private Object param2;
    private Object param3;

    public TestBean() {
    }

    public TestBean(Object param, Object param1, Object param2, Object param3) {
        this.param = param;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Object getD() {
        return d;
    }

    public void setD(Object d) {
        this.d = d;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Object getParam1() {
        return param1;
    }

    public void setParam1(Object param1) {
        this.param1 = param1;
    }

    public Object getParam2() {
        return param2;
    }

    public void setParam2(Object param2) {
        this.param2 = param2;
    }

    public Object getParam3() {
        return param3;
    }

    public void setParam3(Object param3) {
        this.param3 = param3;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                ", d=" + d +
                ", param=" + param +
                ", param1=" + param1 +
                ", param2=" + param2 +
                ", param3=" + param3 +
                '}';
    }
}
