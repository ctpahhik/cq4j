package com.github.ctpahhik.cq4j.data;

import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class CachedDataHolder<T> {

    final T accessor;
    final Map<String, Integer> names;

    public CachedDataHolder(T accessor, Map<String, Integer> names) {
        this.accessor = accessor;
        this.names = names;
    }
}
