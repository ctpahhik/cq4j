package com.github.ctpahhik.cq4j.operations;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class MultiTableDataAccessOperator<T> extends AbstractOperator<T> {

    private IDataAdapter dataProvider;
    private String fieldName;
    private int tableId;
    private int fieldId;

    public MultiTableDataAccessOperator(int tableId, IDataAdapter dataProvider, String fieldName) {
        this.tableId = tableId;
        this.dataProvider = dataProvider;
        this.fieldName = fieldName;
        this.fieldId = dataProvider.getIdByName(fieldName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T evaluate(Object data) {
        Object[] dataArray = (Object[])data;
        return (T)dataProvider.getById(fieldId, dataArray[tableId]);
    }

    @Override
    public boolean isDeterministic() {
        return false;
    }

    @Override
    public String toString() {
        return "MTDAO['" + fieldName + "']";
    }
}
