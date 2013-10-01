package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.data.BeanReflectionDataAdapter;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class ReflectionDataProviderFunctionalTest extends AbstractDataProviderFunctionalTest {

    @Override
    @SuppressWarnings("unchecked")
    protected IDataAdapter createDataAdapter(Class clazz) {
        return new BeanReflectionDataAdapter(clazz);
    }
}
