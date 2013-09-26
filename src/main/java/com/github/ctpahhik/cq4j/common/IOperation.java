package com.github.ctpahhik.cq4j.common;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface IOperation<T> {

    public T evaluate();

    public boolean isPureFunction();
}
