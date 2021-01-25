package com.revature.generics;

// Can use generics to stand for a class
public class GenericClass<T> {

    T instance;
    T[] objArray;

    public GenericClass(T instance) {
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }

    
    
}
