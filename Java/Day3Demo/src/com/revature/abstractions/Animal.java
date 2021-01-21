package com.revature.abstractions;

public abstract class Animal {
    public int numberOfLives = 1;
    protected String value, thing;
    public Animal(){
        System.out.println("Animal Constructor called");
    }
    public void eat(){

    }
    public abstract void makeSound();
}
