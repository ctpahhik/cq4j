package com.github.ctpahhik.cq4j.data;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class BeanReflectionDataAdapter<T> implements IDataAdapter {

    private final static Map<Class, CachedDataHolder<Method[]>> cache = new WeakHashMap<Class, CachedDataHolder<Method[]>>();
    private final Method[] methods;
    private final Map<String, Integer> names;

    public BeanReflectionDataAdapter(Class<T> clazz) {
        try {
            CachedDataHolder<Method[]> holder = cache.get(clazz);
            if (holder != null) {
                methods = holder.accessor;
                names = holder.names;
                return;
            }

            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            methods = new Method[propertyDescriptors.length];
            names = new HashMap<String, Integer>();
            int id = 0;
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                methods[id] = descriptor.getReadMethod();
                names.put(descriptor.getName().toLowerCase(), id);
                id++;
            }
            cache.put(clazz, new CachedDataHolder<Method[]>(methods, names));
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't introspect bean: " + clazz, e);
        }
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
        Integer id = names.get(fieldName.toLowerCase());
        if (id == null) {
            throw new IllegalArgumentException("Unknown field '" + fieldName + "'");
        }
        return id;
    }
}
