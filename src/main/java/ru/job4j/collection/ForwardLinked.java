package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        ForwardLinked.Node<T> newNode = new ForwardLinked.Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            ForwardLinked.Node<T> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        ForwardLinked.Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T result = head.item;
        head.item = head.next.item;
        head.next = head.next.next;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final private int expectedModCount = modCount;
            private ForwardLinked.Node<T> i = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return i != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = i.item;
                i = i.next;
                return result;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private ForwardLinked.Node<T> next;

        Node(T element, ForwardLinked.Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
