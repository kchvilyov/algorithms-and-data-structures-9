package ru.t1.education;

import java.util.List;

public class CounterList<E> implements List<E> {
    private final List<E> delegate;
    private static int addCount = 0;

    public CounterList(List<E> delegate) {
        this.delegate = delegate;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return delegate.iterator();
    }

    @Override
    public Object[] toArray() {
        return delegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return delegate.toArray(a);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return delegate.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    @Override
    public boolean containsAll(java.util.Collection<?> c) {
        return delegate.containsAll(c);
    }

    @Override
    public boolean addAll(java.util.Collection<? extends E> c) {
        addCount += c.size();
        return delegate.addAll(c);
    }

    @Override
    public boolean addAll(int index, java.util.Collection<? extends E> c) {
        addCount += c.size();
        return delegate.addAll(index, c);
    }

    @Override
    public boolean removeAll(java.util.Collection<?> c) {
        return delegate.removeAll(c);
    }

    @Override
    public boolean retainAll(java.util.Collection<?> c) {
        return delegate.retainAll(c);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public E get(int index) {
        return delegate.get(index);
    }

    @Override
    public E set(int index, E element) {
        return delegate.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        addCount++;
        delegate.add(index, element);
    }

    @Override
    public E remove(int index) {
        return delegate.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return delegate.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return delegate.lastIndexOf(o);
    }

    @Override
    public java.util.ListIterator<E> listIterator() {
        return delegate.listIterator();
    }

    @Override
    public java.util.ListIterator<E> listIterator(int index) {
        return delegate.listIterator(index);
    }

    @Override
    public java.util.List<E> subList(int fromIndex, int toIndex) {
        return delegate.subList(fromIndex, toIndex);
    }

    public static int getAddCount() {
        return addCount;
    }

    public static void reset() {
        addCount = 0;
    }
}