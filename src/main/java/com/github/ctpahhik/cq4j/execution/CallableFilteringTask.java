package com.github.ctpahhik.cq4j.execution;

import com.github.ctpahhik.cq4j.Filter;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class CallableFilteringTask<T> implements Callable<List<T>> {

    private Filter<T> filter;
    private List<T> dataSource;

    public CallableFilteringTask(Filter<T> filter, List<T> dataSource) {
        this.filter = filter;
        this.dataSource = dataSource;
    }

    @Override
    public List<T> call() throws Exception {
        return filter.filter(dataSource);
    }
}
