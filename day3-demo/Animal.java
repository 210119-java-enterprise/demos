package com.revature.abstractions;

/*
    Abstract classes

    -Cannot be instantiated (cannot use the new keywords).
    must have a concrete implementation by means of one or more subclasses
    all abstract methods in the class must have an implementation

    still have a construct

    can have zero or more abstract mthods contained
 */
public abstract class Animal {

    public int numberOfLives = 1;
    public String value;
    public String thing;

    public Animal() {
        System.out.println("Animal constructor called!");
    }

    public void eat() {
        System.out.println("The animal eats...");
    }
    // abstract method
    public abstract void makeSound();

    public static void doStuff() {
        System.out.println("The Cat is doing some stuff");
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }
}
