package ru.t1.education;

import java.util.AbstractList;
import java.util.List;

public class CounterList<E> extends AbstractList<E> {
    private final List<E> delegate;
    private static int addCount = 0;

    public CounterList(List<E> delegate) {
        this.delegate = delegate;
    }

    @Override
    public E get(int index) {
        return delegate.get(index);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return delegate.add(e);
    }

    @Override
    public void add(int index, E element) {
        addCount++;
        delegate.add(index, element);
    }

    public static int getAddCount() {
        return addCount;
    }

    public static void reset() {
        addCount = 0;
    }
}