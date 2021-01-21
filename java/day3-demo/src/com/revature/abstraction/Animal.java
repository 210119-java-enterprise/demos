package com.revature.abstraction;

/*
    Abstract class
    - Cannot be directly instantiated
    - all abstract methods in the class MUST be implemented by concrete subclass
    -Still have constructors, because subclasses will leverage these for their own
     instantiation.
    - Can have zero or more abstract methods contained within its declaration.
 */
public abstract class Animal {

    public int numberOfLives = 1;
    public String value ;
    public String thing ;

    public Animal(){
        System.out.println("The animal constructor called!");
    }
    //concrete method (method with implementation)
    public void eat() {
        System.out.println("The animals eats ..");
    }
    // abstract method
    public abstract void makeSound();
    public static void doStuff()
    {
        System.out.println("Doing the stuff!");
    }
}
