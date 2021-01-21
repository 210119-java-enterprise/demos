package com.revature.abstractions;

public abstract class Animals {

    public int numberOfLives = 1;
    public String value;

    public Animals(){
        System.out.println("Animal constructor called");
    }

    public int getNumberOfLives(){
        return numberOfLives;
    }

    public void eat(){
        System.out.println("The animal eats...");
    }

    public abstract void makeSound();

    public static void doStuff(){
        System.out.println("The animal does stuff");
    }

}
