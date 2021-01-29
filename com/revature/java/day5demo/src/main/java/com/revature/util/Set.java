package com.revature.util;

import java.lang.reflect.Array;

public class Set<T> {
    

    private Map<T, Object> map;

    public Set() {
        this.map = new Map<T, Object>();
    }

    public boolean add(T data) {
        // Use hashcode
        return this.map.put(data, data.hashCode()) == null;
    }

    //TODO: maybe change returns?
    public boolean remove(T data) {
        if (this.map.containsKey(data)) {
            this.map.remove(data);
            return true;
        }
        return false;
    }

    public boolean contains(T data) {
        return this.map.containsKey(data);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public int size() {
        return this.map.getSize();
    }

    @SuppressWarnings("unchecked") 
    public T[] toArray(Class<T> clazz) {
        MyLinkedList<T> keys = this.map.keyList();
        // Need to do this to create a primitive array of generic type
        T[] keyArray = (T[]) Array.newInstance(clazz, size());
        for (int i = 0; i < size(); i++) {
            T t = keys.pop();
            keyArray[i] = t;
        }
        return keyArray;
    }

}
