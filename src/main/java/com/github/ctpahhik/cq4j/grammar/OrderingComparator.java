package com.github.ctpahhik.cq4j.grammar;

import com.github.ctpahhik.cq4j.common.IOperator;

import java.util.Comparator;

/**
 * TODO: JavaDoc
 *
 * Null - first
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class OrderingComparator<T> implements Comparator<T> {

    private IOperator<Comparable<Object>> operator;
    private boolean asc = true;

    public OrderingComparator(IOperator<Comparable<Object>> operator) {
        this.operator = operator;
    }

    public OrderingComparator(IOperator<Comparable<Object>> operator, boolean asc) {
        this.operator = operator;
        this.asc = asc;
    }

    @Override
    public int compare(T o1, T o2) {
        Comparable<Object> first = operator.evaluate(o1);
        Comparable<Object> second = operator.evaluate(o2);
        if (first == null) {
            if (second == null) {
                return 0;
            } else {
                return asc ? -1 : 1;
            }
        }
        if (second == null) {
            return asc ? 1 : -1;
        }

        return asc ? first.compareTo(second) : second.compareTo(first);
    }
}
