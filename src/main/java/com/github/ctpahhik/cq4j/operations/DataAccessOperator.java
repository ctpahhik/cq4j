package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class DataAccessOperator<T> extends AbstractOperator<T> {

    private IDataAdapter dataProvider;
    private String fieldName;
    private int fieldId;

    public DataAccessOperator(IDataAdapter dataProvider, String fieldName) {
        this.dataProvider = dataProvider;
        this.fieldName = fieldName;
        this.fieldId = dataProvider.getIdByName(fieldName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T evaluate(Object data) {
        return (T)dataProvider.getById(fieldId, data);
    }

    @Override
    public boolean isDeterministic() {
        return false;
    }

    @Override
    public String toString() {
        return "DAO['" + fieldName + "']";
    }
}
