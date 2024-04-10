package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count * 100 / capacity >= LOAD_FACTOR * 100) {
            expand();
        }
        boolean result = false;
        MapEntry<K, V> newMapEntry = new MapEntry<>(key, value);
        int index = index(key);
        if (table[index] == null) {
            table[index] = newMapEntry;
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private int index(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private boolean comparisonKey(K key) {
        int index = index(key);
        return Objects.hashCode(table[index].key) == Objects.hashCode(key) && Objects.equals(table[index].key, key);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> n : table) {
            if (n != null) {
                newTable[index(n.key)] = n;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        if (table[index(key)] != null) {
            if (comparisonKey(key)) {
                result = table[index(key)].value;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        if (table[index(key)] != null) {
            if (comparisonKey(key)) {
                table[index(key)] = null;
                result = true;
                count--;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index;
            final private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
