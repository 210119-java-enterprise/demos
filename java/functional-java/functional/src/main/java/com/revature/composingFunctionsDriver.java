package com.revature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.revature.models.User;

public class composingFunctionsDriver {
    public static void main(String[] args) {

        Consumer<String> c1 = s -> System.out.println("c1 is consuming " + s);
        Consumer<String> c2 = s -> System.out.println("c2 is consuming " + s);
    
        Consumer<String> c3 = c1.andThen(c2);

        c3.accept("test string");

        Predicate<String> isNull = s -> s == null;
        Predicate<String> isEmpty = s -> s.trim().isEmpty();

        Predicate<String> isEmptyOrNull = isNull.negate().and(isEmpty.negate());

        String s1 = "";
        String s2 = null;
        String s3 = "hi";
        System.out.println("Good string? " + isEmptyOrNull.test(s1));
        System.out.println("Good string? " + isEmptyOrNull.test(s2));
        System.out.println("Good string? " + isEmptyOrNull.test(s3));

        List<String> myStrings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        
        // Comparator<String> cmp1 = (str1, str2) -> s1.compareTo(s2);
        Comparator<String> cmp1 = String::compareTo;
        // Even though this list is immutable, can change around objects
        myStrings.sort(cmp1);
        System.out.println(myStrings);

        // -----------------------------
        // Realistic-ish demo

        User nate = new User("Nate", 22);
        User jay = new User("Jay", 45);
        User kalyb = new User("Kalyb", 22);
        User gabby = new User("Gabby", 24);
        User nate2 = new User("Nate", 21);

        List<User> users = Arrays.asList(nate, jay, kalyb, gabby, nate2);

        Comparator<User> cmpName = Comparator.comparing(User::getName);
        Comparator<User> cmpAge = Comparator.comparing(User::getAge);
        // Orders by name alphabetical, then age low to high
        Comparator<User> cmpUser = cmpName.thenComparing(cmpAge);
        // Orders by age high to low, then name rverse alphabetical
        Comparator<User> reverser = Comparator.comparing(User::getName)
                                                .thenComparing(User::getAge)
                                                .reversed();

        users.sort(cmpUser);
        users.forEach(System.out::println);
        System.out.println();
        users.sort(reverser);
        users.forEach(System.out::println);
        
    }

    
    
}
