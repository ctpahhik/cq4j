package com.github.ctpahhik.cq4j.utils;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.io.IOException;
import java.security.SecureClassLoader;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class SingleFileManager extends ForwardingJavaFileManager {

    private StringJavaFileObject compiled;

    public SingleFileManager(StandardJavaFileManager standardManager) {
        super(standardManager);
    }

    @Override
    public ClassLoader getClassLoader(Location location) {
        return new SecureClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                byte[] b = compiled.getBytes();
                return super.defineClass(name, compiled.getBytes(), 0, b.length);
            }
        };
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        compiled = new StringJavaFileObject(className, kind);
        return compiled;
    }
}