package com.revature.abstractions;

/*
    Abstract classes

        - Cannot be directly instantiated (cannot use the new keyword), must
            have a concrete implementation by means of one or more subclasses
                + all abstract methods in the class MUST be implemented by concrete subclasses

        - Still have constructors, because subclasses will leverage these for their own
            instantiation.

        - Can have zero or more abstract methods contained within its declaration.
            + abstract methods are simply methods that do not have any implementation, also
                called "method stubs";

 */
public abstract class Animal {

    public int numberOfLives = 1;
    public String value;
    protected String thing;

    public Animal() {
        System.out.println("Animal constructor called!");
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    // concrete method (method with an implementation)
    public void eat() {
        System.out.println("The animal eats...");
    }

    // abstract method
    public abstract void makeSound();

    public static void doStuff() {
        System.out.println("The animal is doing some stuff!");
    }


}
