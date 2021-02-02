package com.revature;

public class Driver {

    public static void main(String[] args) {

        // Local anonymous class
        // Can be an inline implementation of any abstract type (interface or abstract class)
        Animal newAnimal = new Animal() {

            @Override
            public void eat() {
                System.out.println("slurp");
            }

//            @Override
//            public void makeSound() {
//                System.out.println("waaakaakaa");
//            }
        };

        // can't use lambdas with things that aren't functional interfaces
//        Animal wontWork = () -> {
//
//        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is a local anonymous class that implements the Runnable interface");
            }
        })

        Thread t2 = new Thread(() -> {
            System.out.println("This is a lambda expression that implements the Runnable interface.");
        });

        t2.start();

        newAnimal.eat();
//        newAnimal.makeSound();

        /*
            Legal Lambda Expression Syntax
                - (parameter) -> expression
                - parameter -> expression
                - parameter -> { code block of expressions }
                - (parameter, parameter) -> expression
                - (parameter, parameter) -> {code block of expressions}
                - () -> expression
                - () -> { code block of expressions }
         */
    }
}
