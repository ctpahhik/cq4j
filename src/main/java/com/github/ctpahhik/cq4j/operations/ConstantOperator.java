package com.github.ctpahhik.cq4j.operations;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ConstantOperator<T> extends AbstractOperator<T> {

    private T value;

    public ConstantOperator(T value) {
        this.value = value;
    }

    @Override
    public T evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
