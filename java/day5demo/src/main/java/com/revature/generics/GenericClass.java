package com.revature.generics;

public class GenericClass<T> {

    T instance;

    T[] objArray;

    public GenericClass(T instance){
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }
}
