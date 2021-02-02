package com.revature;

public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("Nom nom nom");
    }

    @Override
    public void makeSound() {
        System.out.println("woof");
    }
}
