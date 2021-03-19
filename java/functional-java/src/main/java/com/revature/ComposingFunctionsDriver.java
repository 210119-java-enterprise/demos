package com.revature;

import com.revature.models.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ComposingFunctionsDriver {

    public static void main(String[] args) {

        Consumer<String> c1 = s -> System.out.println("c1 is consuming " + s);
        Consumer<String> c2 = s -> System.out.println("c2 is consuming " + s);
        Consumer<String> c3 = c1.andThen(c2);

        c3.accept("test string");

        Predicate<String> isNull = s -> s == null;
//        Predicate<String> isNotNull = s -> s != null; // not necessary, we just use .negate on notNull
        Predicate<String> isEmpty = s -> s.trim().equals("");
        Predicate<String> p3 = isNull.negate().and(isEmpty.negate());

        //-----------------------------------

        // Creating custom Comparators

        List<String> myStrings = Arrays.asList("one", "two", "three", "four",
                                                "five", "six", "seven", "eight", "nine");

//        Comparator<String> cmp1 = (s1, s2) -> s1.compareTo(s2);
        Comparator<String> cmp1 = String::compareTo; // yay method references!

        myStrings.sort(cmp1);
        System.out.println(myStrings);

        Comparator<String> cmp2 = Comparator.comparingInt(String::length);
        myStrings.sort(cmp2);
        System.out.println(myStrings);

        //------------------------------------------------

        User cole = new User("Cole", 22);
        User cole2 = new User("Cole", 21);
        User kalyb = new User("Kalyb", 22);
        User daniel = new User("Daniel", 23);
        User wezley = new User("Wezley", 30);
        User jay = new User("Jay", 50);
        User greg = new User("Greg", 45);

        List<User> users = Arrays.asList(cole, kalyb, daniel, wezley, jay, greg, cole2);

        // Explicit declarations
        Comparator<User> cmpName = Comparator.comparing(User::getName);
        Comparator<User> cmpAge = Comparator.comparing(User::getAge);
        Comparator<User> cmp = cmpName.thenComparing(cmpAge);
        Comparator<User> reverser1 = cmp.reversed();

        // Inline
        Comparator<User> reverser2 = Comparator.comparing(User::getName)
                                                .thenComparing(User::getAge)
                                                .reversed();

        users.sort(reverser1);
        users.forEach(System.out::println);



    }


}
