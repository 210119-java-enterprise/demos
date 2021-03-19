package com.revature.util;

public class Map<K, V> {
    
    private int capacity;
    private final int DEFAULT_CAPACITY = 16;
    private int size;

    // Supresses warning about unsafe type converion for Entry array
    @SuppressWarnings("unchecked") 
    private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];

    public Map() {
        capacity = DEFAULT_CAPACITY;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }
        if (size == 0) {
            return false;
        }
        else {
            for (Entry<K, V> entry : entries) {
                if (entry != null && entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }


    public V get(K key) {
        if (size == 0) {
            return null;
        }
        else {
            for (Entry<K, V> entry : entries) {
                if (entry != null && entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

 
    public V getOrDefault(K key, V value) {
        if (size == 0) {
            return value;
        }
        else {
            for (Entry<K, V> entry : entries) {
                if (entry != null && entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *  Adds a new entry to the map using the provided key and value. Returns
     *  the value previously associated with the key. If the key was not in the map,
     *  returns null. Cannot add null keys
     */
    public V put(K key, V value) {
        if (key == null) {
            return null;
        }
        if (size == 0) {
            entries[0] = new Entry<K,V>(key, value);
            size++;
            return null;
        }
        // If key exists, replace old value
        for (Entry<K, V> entry : entries) {
            if (entry != null && entry.key.equals(key)) {
                V temp = entry.value;
                entry.value = value;
                return temp;
            }
        }
        
        if (size + 1 == capacity) {
            ensureCapacity();
        }
        entries[size + 1] = new Entry<K,V>(key, value);
        size++;

        return null;
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].key != null && entries[i].key.equals(key)) {
                entries[i] = null;
                consdenseArray(i);
                size--;
                return;
            }
        }
    }

    public int getSize() {
        return size;
    }

    // when size = capacity, move all entries into new bigger array
    @SuppressWarnings("unchecked") 
    private void ensureCapacity() {
        capacity *= 2;
        Entry<K,V>[] temp = new Entry[capacity];

        for(int i = 0; i < size; i++) {
            temp[i] = entries[i];
        }

        entries = temp;
    }

    // Condenses array after a remove
    // start is a cut-off point (start becomes new 0)
    @SuppressWarnings("unchecked") 
    private void consdenseArray(int start) {
        if (size <= capacity / 2 && capacity > DEFAULT_CAPACITY) {
            capacity /= 2;
            Entry<K,V>[] temp = new Entry[capacity];
            int count = 0;
            for(int i = 0; i < size; i++) {
                if (entries[i] != null) {
                    temp[count] = entries[i];
                    count++;
                }
            }
            entries = temp;
        } else {
            for(int i = start; i < size - 1; i++) {
                if (entries[i] != null) {
                    entries[i] = entries[i + 1];
                }
            }
            entries[size - 1] = null;
        }


    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        String res = "";
        for (Entry<K,V> entry : entries) {
            if (entry != null) {
                res += entry + "\n";
            }
        }
        return res;
    }

    public MyLinkedList<K> keyList() {
        MyLinkedList<K> keyList = new MyLinkedList<>();
        for (int i = 0; i < capacity; i++) {
            if (entries[i] != null && entries[i].key != null) {
                keyList.append(entries[i].key);
            }
        }
        return keyList;
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
            return "Entry [key=" + key + ", value=" + value + "]";
        }
    }
}
