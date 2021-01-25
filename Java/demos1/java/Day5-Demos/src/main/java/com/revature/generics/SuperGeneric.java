package com.revature.generics;

import java.util.function.Predicate;

// cant be any object, has to be at least animal or lower
// so can set a higher bound for generics
public class SuperGeneric<T extends Husky> {
    T instance;

    public void walkTheT() {
        instance.walk();
    }

    //? - wildcard - can take in a predicate of any type not just integer or whatever
    public void TestTheAnimal(Predicate<? super Animal> wild) {

    }
}

class Animal {
    public void walk(){}
}

class Dog extends Animal{}

class Husky extends Dog{}

class Cat extends Animal{}