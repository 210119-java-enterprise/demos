package com.revature.abstractions;

import java.sql.SQLOutput;

public abstract class Animal {

    /*
        Abstract Classes

            - Cannot be directly instantiated (cannot use new keyword)
            - Must have a concrete implementation by means of one or more subclasses
                + all abstract methods in the class MUST be implemented by concrete subclasses

            - Still have constructors because subclasses will leverage these for their own
                instantiation.

            - Can have 0 or more abstract methods contained within its declaration.
                + abstract methods are simply methods that do not have any implementation, also
                    called "method stubs"
     */

    public int numberOfLives = 1;
    public String value;
    protected String thing;

    public Animal() {
        System.out.println("Animal Constructor called...");
    }

    // concrete method (with implementation)
    public void eat() {
        System.out.println("Animal eats...");
    }

    // abstract method or method stub
    public abstract void makeSound();

    public static void doStuff() {
        System.out.println("The animal is doing some stuff.");
    }
}
