package com.revature;

import com.revature.models.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Driver {

    public static void main(String[] args) {

        // Local anonymous class
        // Can be an inline implementation of any abstract type (interface or abstract class)
        // Local anon classes actually create another class file at compilation (making JAR bigger)
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
        });

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

        // Lambda expressions are converted into private methods at compile time
        Supplier<String> stringSupplier = () -> "Something";
        String someString = stringSupplier.get();
        System.out.println(someString);

        List<String> strings = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));

        System.out.println("+---------------------");
        //toString
        System.out.println(strings.toString());

        System.out.println("+--------------");
        // traditional for-loop
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

        // for each
        System.out.println("+---------------------");
        for (String s: strings) {
            System.out.println(s);
        }

        System.out.println("+---------------");
        // Iterable#forEach using a lambda expression
        strings.forEach(str -> System.out.println(str));

        System.out.println("+---------------------");
        strings.forEach(System.out::println);

    }
}
