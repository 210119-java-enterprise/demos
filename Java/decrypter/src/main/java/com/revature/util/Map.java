package com.revature.util;

import java.util.Arrays;

public class Map<K, V> {

    private int size;
    private final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];

    public Map() {
        size = 0;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key == null) {
                if (entries[i].key == key) {
                    return true;
                }
            } else {
                if (entries[i].key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public LinkedList<K> keyList() {
        LinkedList<K> keyList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            keyList.insert(entries[i].key);
        }
        return keyList;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] == null) {
                if (entries[i] == key) {
                    return entries[i].value;
                }
            } else {
                if (entries[i].key.equals(key)) {
                    return entries[i].value;
                }
            }
        }
        return null;
    }

    public V getOrDefault(K key, V value) {
        V temp = get(key);
        if (get(key) == null) {
            return value;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Adds a new entry to the map using the provided key and value. Returns the value previously associated with the
     * key. If the key was not in the prior, returns null.
     * @param key the key to have the associated value changed
     * @param value the new value to associate with the key
     * @return the previous value associated with the key, returns null if they key didn't have a value
     */
    public V put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (entries[i].key == null) {
                if (entries[i].key == key) {
                    V previousValue = entries[i].value;
                    entries[i].value = value;
                    return previousValue;
                }
            }
            if (entries[i].key.equals(key)) {
                V temp = entries[i]. value;
                entries[i].value = value;
                return temp;
            }
        }

        if (size == entries.length) {
            ensureCapacity();
        }
        entries[size] = new Entry<>(key, value);
        size++;
        return null;
    }

    public void remove(K key) {
        for (int i = 0; i < size-1; i++) {
            if ((entries[i].key == null && entries[i].key == key)) {
                if (entries[i].key == key) {
                    entries[i] = null;
                    size--;
                }
            } else {
                if (entries[i].key.equals(key)) {
                    entries[i] = entries[size - 1];
                    size--;
                }
            }
        }


        if (entries[size].equals(key)) {
            size--;
        }

        if ((size*2) < entries.length) {
            condenseArray(entries.length/2);
        }

    }

    public int size() {
        return size;
    }

    // this method will be helpful after putting new entries into the map
    private void ensureCapacity() {
        entries = Arrays.copyOf(entries, entries.length*2);
    }

    // this method will be helpful after removing a key from the map
    // guessing start is the length to truncate to
    private void condenseArray(int start) {
        entries = Arrays.copyOf(entries, start);
    }

    private static class Entry<K, V> {

        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}
