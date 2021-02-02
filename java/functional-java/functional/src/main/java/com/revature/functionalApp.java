package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class functionalApp 
{
    public static void main( String[] args )
    {
        Supplier<String> stringSupplier = () -> {
            System.out.println("I am the supplier");
            return "Hi";
        };
        String s = stringSupplier.get();
        System.out.println(s);

        Consumer<String> stringConsumer = str -> {
            System.out.println("I am the consumer");
            System.out.println(str);
        };
        stringConsumer.accept("a String");

        Predicate<String> stringPredicate = str -> {
            System.out.println("I am the predicate");
            return str == null || str.trim().equals("");
        };
        s = "hey";
        if (stringPredicate.test(s)) {
            System.out.println("String not null/empty");
        } else {
            System.out.println("String either null or empty");
        }

        // Arrays.asList creates an immutable list
        List<String> immutableStringList = Arrays.asList("one", "two", "three", "four", "five");
        // Original list not changed
        List<String> stringsThatDontStartWithT = immutableStringList.stream()
                .filter(str -> !(str.startsWith("t") || str.startsWith("T")))
                .collect(Collectors.toList());

        System.out.println("-------------------");
        stringsThatDontStartWithT.forEach(System.out::println);

        // There are methods to manipulate and change original list
        List<String> mutableStringList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));

        // strings.removeIf(str -> !(str.startsWith("t") || str.startsWith("T")));
        Predicate<String> startsWithT = str -> {
            return str.startsWith("t") || str.startsWith("T");
        };
        // Throws exception due to way we created list (immutable)
        // strings.removeIf(startsWithT);
        mutableStringList.removeIf(startsWithT);
        mutableStringList.forEach(System.out::println);
        System.out.println("-------------------");

        Function<String, Integer> mapStringToInteger_1 = str -> {
            return Integer.parseInt(str);
        };
        Function<String, Integer> mapStringToInteger_2 = str -> Integer.parseInt(str);
        
        System.out.println(mapStringToInteger_1.apply("1") + 2);
        System.out.println(mapStringToInteger_2.apply("1") + 2);

        // ------------------------------------------------------
        // Primitive function demo

        // Does same thing, but integerSupplier autoboxes 10 into an Integer
        Supplier<Integer> integerSupplier = () -> 10;
        // 10 gets autounboxed into an int
        int i1 = integerSupplier.get();
        System.out.println("i1 = " + i1);

        // No need for autoboxing
        IntSupplier intSupplier = () -> 10;
        int i2 = intSupplier.getAsInt();
        System.out.println("i2 = " + i2);

        DoubleToIntFunction doubleToIntFunction = value -> (int) Math.floor(value);
        int e = doubleToIntFunction.applyAsInt(2.71);
        System.out.println("E as an int is: " + e);
        System.out.println("e cast to int is: " + (int) 2.71);

    }
}
