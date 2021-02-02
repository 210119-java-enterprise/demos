package com.revature;

import com.revature.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalDriver {

    public static void main(String[] args) {

        /*
            Java 8 introduced a package: java.util.function

                - a set of functional interfaces
                - there are more than 40 individual interfaces provided by this package
                - organized into 4 main categories (there is a 5th we will discuss):

                    - Supplier<T>
                        + T get();
                        + takes in no value; returns a value

                    - Consumer<T>
                        + void accept(T val);
                        + takes in a value; returns no value

                    - Predicate<T>
                        + boolean test(T val);
                        + takes in a value; returns a boolean

                    - Function<T, R>
                        + T = the parameter, R = return type
                        + R apply(T val);
                        + takes in a value of type T, returns a value of type R


                The fifth type of functional interface is not actually in the java.util.function
                package. It comes from java.lang, and is the Runnable interface (since java 1.0)
                    + void run();
                    + takes in nothing; returns nothing
         */

        Supplier<String> stringSupplier = () -> {
            System.out.println("I am in the Supplier!");
            return "Hi!";
        };

        String s = stringSupplier.get();
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


        // Gives us an immutable list?
        List<String> immutableStringList = Arrays.asList("one", "two", "three", "four", "five");

        List<String> oldWay = new ArrayList<>();
        for (String str : immutableStringList) {
            if (!(str.startsWith("t") || str.startsWith("T"))) {
                oldWay.add(str);
            }
        }

        for (String str : oldWay) {
            System.out.println(str);
        }

        System.out.println("+----------------------+");

        List<String> stringsThatDontStartWithT = immutableStringList.stream()
                                                        .filter(str -> !(str.startsWith("t") || str.startsWith("T")))
                                                        .collect(Collectors.toList());



        // The original list is unchanged! (an important principle in functional programming)
        immutableStringList.forEach(System.out::println);

        System.out.println("+----------------------+");

        // Contains only "one", "four", and "five"
        stringsThatDontStartWithT.forEach(System.out::println);

        System.out.println("+----------------------+");

        Predicate<String> startsWithT = str -> (str.startsWith("t") || str.startsWith("T"));

        // throws an UnsupportedOperationException (because the way we created this list makes it immutable)
//        immutableStringList.removeIf(startsWithT);
//        immutableStringList.forEach(System.out::println);

        // There are methods on the List interface (and other Collection types) that can take in predicates
        // and manipulate the original collection
        List<String> mutableStringList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
        mutableStringList.removeIf(startsWithT);
        mutableStringList.forEach(System.out::println);

        Function<String, User> mapStringToUser_1 = str -> {
          return new User(str);
        };

        Function<String, User> mapStringToUser_2 = str -> new User(str);

        Function<String, User> mapStringToUser_3 = User::new;

        User mappedUser = mapStringToUser_3.apply("Wezley");
        System.out.println(mappedUser);



    }
}
