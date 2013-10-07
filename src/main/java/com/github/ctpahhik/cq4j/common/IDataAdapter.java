package com.github.ctpahhik.cq4j.common;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface IDataAdapter<T> {

    public Object getByName(String fieldName, T data);

    public Object getById(int fieldId, T data);

    public int getIdByName(String fieldName);
}
