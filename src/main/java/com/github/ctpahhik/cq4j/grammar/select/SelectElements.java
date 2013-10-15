package com.github.ctpahhik.cq4j.grammar.select;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class SelectElements {

    private String value;

    public SelectElements(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SelectElements{" +
                "value='" + value + '\'' +
                '}';
    }
}
