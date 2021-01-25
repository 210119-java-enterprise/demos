package com.revature.generics;

import java.util.function.Predicate;

//Can't be any object, has to be at least Animal or lower
public class SubGeneric<T extends Animal> {

    T instance;

    public void walkTheT() {
        instance.walk();
    }

    public void TestTheAnimal(Predicate<?> wild){}

}

class Animal{
    public void walk(){};
}

class Dog extends Animal{}

class Cat extends Animal{}
