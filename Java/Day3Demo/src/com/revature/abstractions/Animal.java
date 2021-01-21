package com.revature.abstractions;

/*
        Abstract classes

            - cannot be directly instantiated (cannot use the new keyword) must have a cnocrete
            implementation by means of one or more sublcasses
                - all abstract methods in the class MUST be implementted by concrete sublclasses

           - still have constructors, because subclasses will leverage theses for own
           instantiation

           - can have zero or more abstract methods contained within its declaration.
           + abstract methods are simply methods that do not have implmenentation, also
           called "method stubs"
 */

public abstract class Animal {
    public int numberOfLives = 1;
    public String value;
    protected String thing;

    public Animal(){
        System.out.println("Animal constructor called!");
    }

    // concrete method (method with an implementation)
    public void eat(){
        System.out.println("The animal eats...");
    }

    // abstract method
    public abstract void makeSound();

 //   public doStuff(){

//    }

    public int getNumberOfLives() {
        return numberOfLives;
    }
}
