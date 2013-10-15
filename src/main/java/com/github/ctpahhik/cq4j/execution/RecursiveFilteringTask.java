package com.github.ctpahhik.cq4j.execution;

import com.github.ctpahhik.cq4j.Filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class RecursiveFilteringTask<T> extends RecursiveTask<List<T>> {

    private static final int FORK_SIZE = 10; //TODO: find optimal
    private List<T> dataSource;
    private Filter<T> filter;

    public RecursiveFilteringTask(Filter<T> filter, List<T> dataSource) {
        this.filter = filter;
        this.dataSource = dataSource;
    }

    @Override
    protected List<T> compute() {
        int size = dataSource.size();
        if (size < FORK_SIZE) {
            return computeDirectly();
        } else {
            List<T> result = new ArrayList<T>();
            int mid = size / 2;
            RecursiveFilteringTask<T> first = new RecursiveFilteringTask<T>(filter, dataSource.subList(0, mid));
            first.fork();
            RecursiveFilteringTask<T> second = new RecursiveFilteringTask<T>(filter, dataSource.subList(mid, size));
            second.fork();
            result.addAll(first.join());
            result.addAll(second.join());
            return result;
        }
    }

    private List<T> computeDirectly() {
        return filter.filter(dataSource);
    }
}
