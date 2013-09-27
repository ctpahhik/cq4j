package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IDataProvider;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class DataAccessOperator<T> extends AbstractOperator<T> {

    private IDataProvider dataProvider;
    private String fieldName;
    private int fieldId;

    public DataAccessOperator(IDataProvider dataProvider, String fieldName) {
        this.dataProvider = dataProvider;
        this.fieldName = fieldName;
        this.fieldId = dataProvider.getIdByName(fieldName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T evaluate() {
        return (T)dataProvider.getById(fieldId);
    }

    @Override
    public boolean isPureFunction() {
        return false;
    }

    @Override
    public String toString() {
        return "DAO['" + fieldName + "']";
    }
}
