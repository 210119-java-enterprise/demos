package com.revature.generics;

//We can use generics to stand for a class that we define upon instantiation.
public class GenericClass<T> {

    T instance;

    T[] objArray;

    public T getInstance(){
        return instance;
    }

    public void setInstance(T t) {
        this.instance = t;
    }

    public GenericClass(T instance) {
        this.instance = instance;
    }
}
