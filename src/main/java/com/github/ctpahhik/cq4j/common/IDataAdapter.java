package com.github.ctpahhik.cq4j.common;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface IDataAdapter {

    public Object getByName(String fieldName, Object data);

    public Object getById(int fieldId, Object data);

    public int getIdByName(String fieldName);
}
