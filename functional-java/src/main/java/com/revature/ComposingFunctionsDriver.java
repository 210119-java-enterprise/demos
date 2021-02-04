package com.revature;

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

        Predicate<String> isNull= s->s==null;
        Predicate<String> isNotNull= s->s!=null;
        Predicate<String> isEmpty= s->s.trim().equals("");
        Predicate<String> p3= isNull.negate().and(isEmpty.negate());


        List<String> myStrings= Arrays.asList("one","two" , "three" , "four" , "five" , "six" , "seven" , "eight" ,"nine" );

        Comparator<String> cmp1=(s1,s2)->s1.compareTo(s2);

        myStrings.sort(cmp1);
        System.out.println(myStrings);



    }


}
