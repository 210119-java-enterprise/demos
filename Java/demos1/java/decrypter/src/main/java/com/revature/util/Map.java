package com.revature.util;

public class Map<K, V> {

    private int size;
    private final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];

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



    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {

            if(entries[i].key == null) {
                if (entries[i].key == key) {
                    return true;
                }
            }
            if(entries[i].key == key) {
                return true;
            }
        }
        return false;
    }

    public V get(K key) {

        for (int i = 0; i < size; i++) {

            if(entries[i].key == null) {
                if (entries[i].key == key) {
                    return entries[i].value;
                }
            }
            if(entries[i].key == key) {
                return entries[i].value;
            }
        }
//        return false;
//
//        for (int i = 0; i < size; i++) {
//            if (entries[i] != null && i == (Integer) key) {
//                return entries[i].value;
//            }
//        }
        return null;
    }

    public void printMap() {
        System.out.println(size);
        System.out.println(entries.length);
        for (int i = 0; i < size; i++) {
            System.out.println("Pair: " + entries[i]);
            //System.out.println("Key: " + entries[i].key + " value: " + entries[i].value);
        }
    }

    //??
    public V getOrDefault(K key, V value) {

        if (!containsKey(key)) {
            return null;
        }

        return get(key);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //adds new entry to map using provided key value returns previously associated value if key is occupied
    public V put(K key, V value) {

        V previousValue = null;

        if (containsKey(key)) {
            //know the key is occupied
            for (int i = 0; i < size; i++) {
                if (entries[i].value.equals(key)) {
                    V savedV = entries[i].value;
                    entries[i].value = value;
                    size++;
                    return savedV;
                }
            }
            return null;
        } else {
            if (size < entries.length) {
                Entry<K, V> dummyEntry = new Entry<>(key, value);
                entries[size] = dummyEntry;
                size++;
                return null;
            } else {
                ensureCapacity();
                Entry<K, V> dummyEntry = new Entry<>(key, value);
                entries[size] = dummyEntry;
                size++;
                return null;
            }
        }
    }

    public void remove(K key) {
        Entry<K, V>[] tempEntries = new Entry[entries.length * 2];
        boolean wasRemoved = false;
        for (int i = 0; i < size; i++) {
            if (entries[i].key == null) {
                if (entries[i].key == key) {
                    entries[i] = null;
                    size--;
                    wasRemoved = true;
                }
            } else if(entries[i].key.equals(key)) {
                entries[i] = null;
                size--;
                wasRemoved = true;
            }
        }



        entries = tempEntries;
    }

    public int size() {
        return size;
    }

    public LinkedList<K> keyList() {
        LinkedList<K> keyList = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            keyList.insert(entries[i].key);
        }
        return keyList;
    }

    //allows it to grow
    private void ensureCapacity() {

        Entry<K, V>[] tempEntries = new Entry[entries.length * 2];
        for (int i = 0; i < entries.length; i++) {
            tempEntries[i] = entries[i];
        }
        entries = tempEntries;
        // if size is same as length of entry array need to increase size
    }

        // this method will be helpful after removing key from map
    //start at certain position and start chopping off items from there...
    //          10
        // |x|y|z|x|e|f|||||||||||||||||||
    private void condenseArray(int start) {
        int numsChopped = entries.length - start;
        Entry<K, V>[] tempEntries = new Entry[start];
        for (int i = 0; i < entries.length; i++) {
            tempEntries[i] = entries[i];
        }
        entries = tempEntries;
    }

}
