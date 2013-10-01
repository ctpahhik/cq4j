package com.github.ctpahhik.cq4j.utils;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class StringJavaFileObject extends SimpleJavaFileObject {

    private String code;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public StringJavaFileObject(String name, String code) {
        this(name, Kind.SOURCE);
        this.code = code;
    }

    public StringJavaFileObject(String name, Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }

    public byte[] getBytes() {
        return bos.toByteArray();
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }
}