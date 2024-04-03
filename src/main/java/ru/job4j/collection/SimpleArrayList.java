package ru.job4j.collection;


import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (container.length == size) {
            container = grow();
        }
            container[size] = value;
            size++;
            modCount++;
    }

    private T[] grow() {
        if (container.length == 0) {
            return Arrays.copyOf(container, 1);
        }
        return Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T result = container[index];
        container[index] = newValue;
        return result;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        size--;
        modCount++;
        T result = container[index];
        if ((size) > index) {
            System.arraycopy(container, index + 1, container, index, size - index);
        }
        container[size] = null;
        return result;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final private int expectedModCount = modCount;
            private int point;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }
}
