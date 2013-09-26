package com.github.ctpahhik.cq4j.manual;

import com.github.ctpahhik.cq4j.common.IDataProvider;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class FakeDataProviderImpl implements IDataProvider {

    @Override
    public Object getByName(String fieldName) {
        return fieldName;
    }

    @Override
    public Object getById(int fieldId) {
        return fieldId;
    }

    @Override
    public int getIdByName(String fieldName) {
        return 42;
    }
}
