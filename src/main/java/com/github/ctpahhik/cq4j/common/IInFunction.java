package com.github.ctpahhik.cq4j.common;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface IInFunction<T> extends IOperation<T> {

    public String getName();

    public IInFunction create(IOperation valueOp, IOperation inValueOp, IOperation<Integer> fromValueOp);
}
