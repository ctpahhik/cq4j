package com.github.ctpahhik.cq4j.data;

import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.utils.SingleFileManager;
import com.github.ctpahhik.cq4j.utils.StringJavaFileObject;

import javax.tools.*;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class BeanCodeGenDataAdapter<T> implements IDataAdapter<T> {

    private static final Map<Class, CachedDataHolder<GeneratedAdapter>> generatedCache = new WeakHashMap<Class, CachedDataHolder<GeneratedAdapter>>();
    private final Map<String, Integer> names;
    private final GeneratedAdapter<T> adapter;

    public BeanCodeGenDataAdapter(Class<T> clazz) {
        StringBuilder builder = null;
        try {
            CachedDataHolder<GeneratedAdapter> holder = generatedCache.get(clazz);
            if (holder != null) {
                adapter = holder.accessor;
                names = holder.names;
                return;
            }
            names = new HashMap<String, Integer>();
            String className = clazz.getSimpleName();
            String packageName = this.getClass().getPackage().getName();
            builder = new StringBuilder("package ").append(packageName).append(";\n\n");
            builder.append("import ").append(clazz.getCanonicalName()).append(";\n\n")
                .append("public class BeanAdapter implements ").append(GeneratedAdapter.class.getCanonicalName()).append("<").append(className).append("> {\n\n")
                .append("\tpublic Object getValue(int id, ").append(className).append(" data) {\n")
                .append("\t\tswitch (id) {\n");
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            int id = 0;
            for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
                builder.append("\t\t\tcase ").append(id).append(":").append(" return data.").append(descriptor.getReadMethod().getName()).append("();\n");
                names.put(descriptor.getName().toLowerCase(), id);
                id++;
            }
            builder.append("\t\t}\n");
            builder.append("\t\tthrow new IllegalArgumentException(\"Unknown field Id: \" + id);\n");
            builder.append("\t}\n");
            builder.append("}\n");

            JavaFileObject file = new StringJavaFileObject(packageName + ".BeanAdapter", builder.toString());
            Iterable<? extends JavaFileObject> compilationUnits = Collections.singletonList(file);

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            JavaFileManager fileManager = new SingleFileManager(compiler.getStandardFileManager(diagnostics, null, null));
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);

            if (!task.call()) {
                throw new IllegalStateException("Couldn't compile generated adapter class: " + diagnostics.getDiagnostics());
            }
            adapter = (GeneratedAdapter<T>) fileManager.getClassLoader(null).loadClass(packageName + ".BeanAdapter").getConstructor().newInstance();
            generatedCache.put(clazz, new CachedDataHolder<GeneratedAdapter>(adapter, names));
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't generate adapter class for bean: " + clazz + " Code: " + builder, e);
        }
    }

    @Override
    public Object getByName(String fieldName, T data) {
        return getById(getIdByName(fieldName), data);
    }

    @Override
    public Object getById(int fieldId, T data) {
        try {
            return adapter.getValue(fieldId, data);
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

    public interface GeneratedAdapter<T> {
        public Object getValue(int id, T data);
    }
}

