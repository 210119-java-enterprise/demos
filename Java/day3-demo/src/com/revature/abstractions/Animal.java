package com.revature.abstractions;
 /*
 Abstract classes
    -cannot be directly instantiated, (cant use new keyword), must have
    a concrete implementation by means of one or more subclasses
        - all abstract methods in the class
          MUST be implemented by concrete classes
    - still have constructors, because subclasses will leverage these for
    their own instatntiation

    - can have 0 or more abstrace methods contained
  */
public abstract class Animal {
    public int numberOfLives = 1;

    public Animal() {
        System.out.println("Animal Constructor");

    }

    public void eat() {
        System.out.println("the animal eats...");
    }
    //abstract method
    public abstract void makeSound();

}
