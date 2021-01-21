package com.revature.abstractions;

/* Abstract class cannot be directly instanciated, must have concrete implementation by one or more subclasses
    Still have constructors...
    Similar to interface but can have some declared and some nondeclared methods
 */

public abstract class Animal {

    public int numberOfLives = 1;
    public String value;
    protected String thing;
    public Animal() {
        System.out.println("animal constructor called");
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public void eat() {
        System.out.println("animal eats");
    }

    public abstract void makeSound ();

}
