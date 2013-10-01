package com.github.ctpahhik.cq4j;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.data.BeanCodeGenDataAdapter;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class CodeGenDataProviderFunctionalTest extends AbstractDataProviderFunctionalTest {

    @Override
    @SuppressWarnings("unchecked")
    protected IDataAdapter createDataAdapter(Class clazz) {
        return new BeanCodeGenDataAdapter(clazz);
    }
}
