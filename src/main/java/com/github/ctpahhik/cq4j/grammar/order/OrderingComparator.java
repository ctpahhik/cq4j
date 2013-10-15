package com.github.ctpahhik.cq4j.grammar.order;

import java.util.Comparator;
import java.util.List;

/**
 * TODO: JavaDoc
 *
 * Null - first
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class OrderingComparator<T> implements Comparator<T> {

    private List<Comparator<T>> comparators;

    public OrderingComparator(List<Comparator<T>> comparators) {
        this.comparators = comparators;
    }

    @Override
    public int compare(T o1, T o2) {
        int cmp = 0;
        for (Comparator<T> comparator : comparators) {
            cmp = comparator.compare(o1, o2);
            if (cmp != 0) {
                break;
            }
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "OrderingComparator{" +
                "comparators=" + comparators +
                '}';
    }
}
