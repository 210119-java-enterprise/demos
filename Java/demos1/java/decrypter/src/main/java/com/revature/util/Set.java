package com.revature.util;

public class Set<T> {

    private Map<T, Object> map;

    public set() {
        this.map = new Map<>();
    }

    public boolean add(T data) {
        return this.map.put(data, data.hashCode()) == null;
    }

    public boolean contains(T data) {
        return this.map.containsKey(data);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    //probably should return something other than true all the time maybe
    public boolean remove(T data) {
        this.map.remove(data);
        return true;
    }

    public int size() {
        return this.map.size();
    }

    public T[] toArray() {
        LinkedList<T> keys = this.map.keyList();
    }
}
