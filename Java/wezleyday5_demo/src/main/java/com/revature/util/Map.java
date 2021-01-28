package com.revature.util;

import java.util.Arrays;

public class Map<K, V> {

    private int size;
    private final int DEFAULT_CAPACITY = 16;

    // Gives a warning, but this is the best way to create an array of Generic Types.
    @SuppressWarnings("unchecked")
    private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];

    public boolean containsKey(K key) {
        for(int i = 0; i < size; i++){
            if(entries[i].key == null) {
                if(entries[i].key == key)
                    return true;
            }else if(entries[i].key.equals(key))
                    return true;
        }

        return false;
    }

    // If you allow developers to implicitly add a null value, might need to not use .equals
    public V get(K key) {
        for(int i = 0; i < size; i++){
            if(entries[i].key == null) {
                if(entries[i].key == key)
                    return entries[i].value;
            }else if(entries[i].key.equals(key))
                return entries[i].value;

        }

        return null;
    }

    public LinkedList<K> keyList() {
        LinkedList<K> keyList = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            keyList.insert(entries[i].key);
        }

        return keyList;
    }

    public V getOrDefault(K key, V value) {
        if(!containsKey(key))
            return value;
        return get(key);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a new entry to the map using the provided key and value. Returns the
     * value previously associated with the key. If the key was not in the map prior,
     * returns null.
     *
     * @param key
     * @param value
     * @return the previous value associated with the key, could return null
     */
    public V put(K key, V value) {
        V oldValue = null;
        boolean wasInserted = true;

        for (int i = 0; i < size; i++) {
            if (entries[i].key == null) {
                if(entries[i].key == key){
                    oldValue = entries[i].value;
                    entries[i].value = value;
                    wasInserted = false;
                    break;
                }
            }else if (entries[i].key.equals(key)) {
                oldValue = entries[i].value;
                entries[i].value = value;
                wasInserted = false;
                break;
            }
        }

        if(wasInserted){
            ensureCapacity();
            entries[size++] = new Entry(key, value);
        }
        return oldValue;
    }

    public void remove(K key) {
        for(int i = 0; i < size; i++){
            if(entries[i].key == null) {
                if(entries[i].key == key){
                    entries[i] = null;
                    size--;
                    condenseArray(i);
                }
            }else if(entries[i].key.equals(key)){
                entries[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    public int size() {
        return size;
    }

    // This method will be helpful after putting new entries into the map.
    private void ensureCapacity() {
        if(size == entries.length)
            entries = Arrays.copyOf(entries, entries.length * 2);
    }

    // This method will be helpful after removing a key from the map.
    private void condenseArray(int start) {
        for(int i = start; i < size; i++){
            entries[i] = entries[i+1];
        }
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
