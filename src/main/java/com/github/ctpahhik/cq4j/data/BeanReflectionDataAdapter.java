package com.github.ctpahhik.cq4j.data;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class BeanReflectionDataAdapter<T> implements IDataAdapter {

    private final Method[] methods;
    private final Map<String, Integer> namesCache = new HashMap<String, Integer>();

    public BeanReflectionDataAdapter(Class<T> clazz) {
        this.methods = clazz.getMethods();
    }

    @Override
    public Object getByName(String fieldName, Object data) {
        return getById(getIdByName(fieldName), data);
    }

    @Override
    public Object getById(int fieldId, Object data) {
        try {
            return methods[fieldId].invoke(data);
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't get field value by Id. Id: '" +fieldId + "'", e);
        }
    }

    @Override
    public int getIdByName(String fieldName) {
        Integer id = namesCache.get(fieldName);
        if (id == null) {
            for (int i = 0; i<methods.length; i++) {
                String methodName = methods[i].getName();
                if (methodName.equalsIgnoreCase("get" + fieldName)
                        || methodName.equalsIgnoreCase("is" + fieldName)
                        || methodName.equalsIgnoreCase(fieldName)) {
                    namesCache.put(fieldName, i);
                    return i;
                }
            }
        } else {
            return id;
        }

        throw new IllegalArgumentException("Unknown field '" + fieldName + "'");
    }
}
