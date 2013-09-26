package com.github.ctpahhik.cq4j.operations;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ConstantOperation<T> extends AbstractOperation<T> {

    private T value;

    public ConstantOperation(T value) {
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
