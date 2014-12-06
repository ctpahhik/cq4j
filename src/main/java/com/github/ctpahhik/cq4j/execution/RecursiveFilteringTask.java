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
    private int from;
    private int to;

    public RecursiveFilteringTask(Filter<T> filter, List<T> dataSource) {
        this.filter = filter;
        this.dataSource = dataSource;
        this.from = from;
        this.to = to;
    }

    private RecursiveFilteringTask(Filter<T> filter, List<T> dataSource, int from, int to) {
        this(filter, dataSource);
        this.from = from;
        this.to = to;
    }

    @Override
    protected List<T> compute() {
        if ((to - from) < FORK_SIZE) {
            return computeDirectly();
        } else {
            List<T> result = new ArrayList<T>();
            int mid = (from + to) / 2;
            RecursiveFilteringTask<T> first = new RecursiveFilteringTask<T>(filter, dataSource, from, mid);
            first.fork();
            RecursiveFilteringTask<T> second = new RecursiveFilteringTask<T>(filter, dataSource, from + split, to);
            second.fork();
            result.addAll(first.join());
            result.addAll(second.join());
            return result;
        }
    }

    private List<T> computeDirectly() {
        List<T> ds = new ArrayList<T>();
        for (int i = from; i < to; i++) {
            ds.add(dataSource.get(i));
        }
        return filter.filter(ds);
    }
}
