package com.github.ctpahhik.cq4j.common;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface IOperator<T> {

    public T evaluate(Object data); //TODO: Make 'data' -> generic type

    public boolean isDeterministic();
}
