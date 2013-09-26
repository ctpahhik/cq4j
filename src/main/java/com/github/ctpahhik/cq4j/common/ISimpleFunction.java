package com.github.ctpahhik.cq4j.common;

import java.util.List;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface ISimpleFunction<T> extends IOperation<T> {

    public String getName();

    public ISimpleFunction create(List<IOperation> parameters);
}
