package com.github.ctpahhik.cq4j.execution;

import com.github.ctpahhik.cq4j.Query;
import com.github.ctpahhik.cq4j.common.IOperator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class CallableFilteringTask<T> implements Callable<Collection<T>> {

    private Query<T> query;
    private List<T> dataSource;

    public CallableFilteringTask(Query<T> query, List<T> dataSource) {
        this.query = query;
        this.dataSource = dataSource;
    }

    @Override
    public Collection<T> call() throws Exception {
        return query.filter(dataSource);
    }
}
