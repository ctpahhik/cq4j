package com.github.ctpahhik.cq4j.data;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
@Deprecated //draft
public class BeanInvokeDynamicDataAdapter<T> implements IDataAdapter<T> {

    private Class<T> clazz;
    private final Method[] methods;
    private final MethodHandle[] methodHandles;
    private final Map<String, Integer> namesCache = new HashMap<String, Integer>();

    public BeanInvokeDynamicDataAdapter(Class<T> clazz) {
        this.clazz = clazz;
        methods = clazz.getMethods();
        this.methodHandles = new MethodHandle[methods.length];
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(Object.class, clazz);

        for (int i = 0; i < methods.length; i++) {
            try {
                methodHandles[i] = lookup.unreflect(methods[i]).asType(methodType);
            } catch (Exception ignore) {
                System.out.println("ignore = " + ignore);
            }
        }
    }

    @Override
    public Object getByName(String fieldName, T data) {
        return getById(getIdByName(fieldName), data);
    }

    @Override
    public Object getById(int fieldId, T data) {
        try {
            MethodHandle handle = methodHandles[fieldId];
            if (handle != null) {
                return handle.invokeExact(clazz.cast(data)); //TODO: fix to 'invokeExact' if possible w/o it performance is very bad
            } else {
                return methods[fieldId].invoke(data);
            }
        } catch (Throwable e) {
            try {
                return methods[fieldId].invoke(data);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Can't get field value by Id. Id: '" +fieldId + "'", ex);
            }
        }
    }

    @Override
    public int getIdByName(String fieldName) {
        Integer id = namesCache.get(fieldName);
        if (id == null) {
            for (int i = 0; i < methods.length; i++) {
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
