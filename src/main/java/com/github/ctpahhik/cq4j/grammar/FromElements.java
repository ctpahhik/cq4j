package com.github.ctpahhik.cq4j.grammar;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class FromElements {

    private Map<String, IDataAdapter> dataAdapters;

    public FromElements(Map<String, IDataAdapter> dataAdapters) {
        this.dataAdapters = dataAdapters;
    }

    public Map<String, IDataAdapter> getDataAdapters() {
        return dataAdapters;
    }

    @Override
    public String toString() {
        return "FromElements{" +
                "dataAdapters=" + dataAdapters +
                '}';
    }
}
