package com.revature.generics;

import java.util.function.Predicate;

// Makes sure T is Animal or a subclass of Animal
public class SubGeneric<T extends Animal> {

    T instance;

    public void walkTheAnimal() {
        instance.walk();
    }

    // ? is a wildcard, allows any type (can limit same as T)
    public void testTheAnimal(Predicate<? super Dog> wild) {

    }
    
}


class Animal {
    public void walk(){}
}

class Dog extends Animal {}

class Cat extends Animal {}