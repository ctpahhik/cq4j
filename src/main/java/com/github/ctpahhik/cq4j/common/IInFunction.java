package com.github.ctpahhik.cq4j.common;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface IInFunction<T> extends IOperator<T> {

    public String getName();

    public IInFunction create(IOperator valueOp, IOperator inValueOp, IOperator<Integer> fromValueOp);
}
