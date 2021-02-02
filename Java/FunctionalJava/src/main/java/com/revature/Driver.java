package com.revature;

public class Driver {

    public static void main(String[] args) {

        Animal newAnimal = new Animal() {

            @Override
            public void eat() {
                System.out.println("slurp");
            }

            @Override
            public void makeSound() {
                System.out.println("waaakaakaa");
            }
        };

        newAnimal.eat();
        newAnimal.makeSound();
    }
}
