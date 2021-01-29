package com.revature.abstractions;
/*
Abstract classes
    >cannot be directly instantiated, must have
      a concrete implementation by means of one or more subclasses
      +all abstract methods in the class MUST be implemented by concrete subclasses

      >Still have constructors ,becuase subclasses will leverage these for their own instantiation

      >can have zero or more abstact methods contained within its declaration.
      +abstract methods are simply methods that do not have any implementaton, also called "method stubs

 */
abstract class Animal {
    public int numberofLives=1;
    public String value;
    public String thing;

    public Animal(){
        System.out.println("Animal constructor called!");

    }
    //concreate method(method with an implementation)
    public void eat(){
        System.out.println("the animal eats");
    }
    //abstract method
    public abstract void makesound();

    public static void doStuff(){
        System.out.println("this cat is doing stuff         ");
    }

}
