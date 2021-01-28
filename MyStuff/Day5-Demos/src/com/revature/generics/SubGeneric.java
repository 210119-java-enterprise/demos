package com.revature.generics;


import java.util.function.Predicate;

// cant be any object. has to be animal or lower
public class SubGeneric <T extends Animal> {
    T instance;

    public void walkTheT(){
        instance.walk();
    }
    //
    public void testTheAnimal(Predicate<? extends Animal> wild){}
}

class Animal{
    public void walk(){}
}

class Dog extends Animal{}

class Cat extends Animal{}
