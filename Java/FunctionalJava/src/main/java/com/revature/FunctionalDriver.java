package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalDriver {

    /*
        Java 8 introduced a  package: java.util.function

            - a set of functional interfaces
            - there are more than 40 individuals interfaces provided by this package
            - organized into 4 main categories (there is a 5th we will discuss):

                - Supplier<T>
                    + T get();
                    + takes in no value; returns a value

                - Consumer<T>
                    + void accept(T val);
                    + takes in a value; returns no value

                - Predicate<T>
                    + boolean test(T val)
                    + takes in a value; returns a boolean

                - Function<T, R>
                    + T = the parameter, R = return tyoe
                    + R apply(T val);
                    +takes in a value of type T, returns a value of type R
     */

    public static void main(String[] args) {
        String s;

        Supplier<String> stringSupplier = () -> {
            System.out.println("I am in the Supplier");
            return "Hi!";
        };

        s = stringSupplier.get();
        System.out.println(s);

        Consumer<String> stringConsumer = str -> {
            System.out.println("I am in the Consumer!");
            System.out.println(str);
        };

        stringConsumer.accept("a string");

        Predicate<String> stringPredicate = str -> {
            System.out.println("I am in the Predicate!");
            return (str == null || str.trim().equals(""));
        };

        s = ".";
        if (stringPredicate.test(s)) {
            System.out.println("The provided string is null or empty");
        } else {
            System.out.println("The provided string is not null or empty");
        }

        List<String> strings = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));

        List<String> oldWay = new ArrayList<>();
        for (String str : strings) {
            if (!(str.startsWith("t") || str.startsWith("T"))) {
                oldWay.add(str);
            }
        }

        for (String str: oldWay) {
            System.out.println(str);
        }


        List<String> stringsThatDontStartWithT = strings.stream()
                                                .filter(str -> !(str.startsWith("t") || str.startsWith("T")))
                                                .collect(Collectors.toList());

        // The original list is unchanged! (an important principle in functional programming)
        strings.forEach(System.out::println);

        System.out.println("+-----------------------------");

        // contains only "one", "four" and "five"
        stringsThatDontStartWithT.forEach(System.out::println);

        System.out.println("+------------------------");

        Predicate<String> startsWithT = str -> (str.startsWith("T") || str.startsWith("t"));

        // There are methods on the List interface (and other Collection types) that can take in predicates and
        // manipulate the original collection
        List<String> mutableStringList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
        mutableStringList.removeIf(startsWithT);
        mutableStringList.forEach(System.out::println);

        strings.removeIf(startsWithT);
        strings.forEach(System.out::println);

        Function<String, Integer> stringIntegerFunction;
    }
}
