package com.revature.generics;

// generics stand for a class that we define upon instantiation
public class GenericClass<T> {

    T instance;

    T[] objArray;

    public GenericClass(T instance) {
        this.instance = instance;
    }

    public T getInstance (){
        return instance;
    }

    public void setInstance(T t) {
        this.instance = t;
    }
}
