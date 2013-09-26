package com.github.ctpahhik.cq4j.common;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public interface IDataProvider {

    public Object getByName(String fieldName);

    public Object getById(int fieldId);

    public int getIdByName(String fieldName);
}
