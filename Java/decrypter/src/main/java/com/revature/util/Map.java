package com.revature.util;

public class Map<K,V> {

    private int size;
    private final int DEFAULT_CAPACITY= 16;

    @SuppressWarnings("unchecked")
    private Entry<K,V>[] entries = new Entry[DEFAULT_CAPACITY];

    public boolean containsKey(K key){
        return false;
    }

    public V get(K key){
        return null;
    }

    public V getOrDefault(K key, V value){
        return null;
    }

    public boolean isEmpty(){
        return false;
    }

    /*
        Adds a new entry to the map using the provided key and value.  Returns the
        value previously associated with the key.  If the key was not in the map prior,
        returns null

        @param key
        @param value
        @return the previous value associated with the key, could still return null
     */

    public V put (K key, V value){
        return null;
    }

    public void remove(K key){

    }

    public int size(){
        return size;

    }

    // this method will be helpful after putting new entries into the map
    private void ensureCapacity(){

    }

    // this method will be helpful after removing a key from the map
    private void condenseArray(int start){

    }


    private static class Entry<K,V>{
        private final K key;
        private V value;

        public Entry(K key, V value){
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
