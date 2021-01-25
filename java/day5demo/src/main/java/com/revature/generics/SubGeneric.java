package com.revature.generics;

import java.util.function.Predicate;

public class SubGeneric<T extends Animal> {

    T instance;

    public void walkTheT(){
        instance.walk();
    }

    //? is the wildcard for generics
    //the extends/super allows to constrict the wildcard
    public void testTheAnimal(Predicate<? super Animal> wild){

    }
}

class Animal{
    public void walk(){}
}

class Dog extends Animal{}

class Cat extends Animal{}