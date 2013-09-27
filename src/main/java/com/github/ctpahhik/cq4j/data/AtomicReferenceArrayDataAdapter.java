package com.github.ctpahhik.cq4j.data;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class AtomicReferenceArrayDataAdapter implements IDataAdapter {

    private final Map<String, Integer> fields;

    public AtomicReferenceArrayDataAdapter(Map<String, Integer> fields) {
        this.fields = new HashMap<String, Integer>(fields);
    }

    @Override
    public Object getByName(String fieldName, Object data) {
        return getById(getIdByName(fieldName), data);
    }

    @Override
    public Object getById(int fieldId, Object data) {
        return ((AtomicReferenceArray) data).get(fieldId);
    }

    @Override
    public int getIdByName(String fieldName) {
        Integer result = fields.get(fieldName);
        if (result == null) {
            throw new IllegalArgumentException("Unknown field '" + fieldName + "'");
        }
        return result;
    }
}
