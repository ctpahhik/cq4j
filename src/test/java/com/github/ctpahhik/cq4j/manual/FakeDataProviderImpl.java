package com.github.ctpahhik.cq4j.manual;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class FakeDataProviderImpl implements IDataAdapter {

    @Override
    public Object getByName(String fieldName, Object data) {
        return fieldName;
    }

    @Override
    public Object getById(int fieldId, Object data) {
        return fieldId;
    }

    @Override
    public int getIdByName(String fieldName) {
        return 42;
    }
}
