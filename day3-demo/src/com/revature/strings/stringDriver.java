package com.revature.strings;

public class stringDriver {

    public static void main(String[] args) {

        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        // string pool is a special area inside heap memory that java leverages to strore string
        // objects with unique values. ( implements the flywheel pattern)

        // not all strings are stored in the string pool if you explicitly use the new keyword to instantiate them
        // strings that are returned from zny string API method are not in the pool
        // if you use literal notation with the same value as an existing string s single string object will be added to the pool

        System.out.println(s1 == s2); // true; since we created two strings witht the same value, these
        // refrences poin to the same object

        System.out.println(s1 == s3); // false since we explicitly used new it created a different object witht the same value

        System.out.println(s1.equals(s3)); // true; because we are checling for value equality

        // string interning is the act of moving a string object - which exists
        // outside of the string pool - and - interning or moving it into the string poool

        String s5 = s3.intern();
        System.out.println(s1 == s3); // false technically didnt get interned the method is returning an intern string
        System.out.println(s2 == s3); // also false
        System.out.println(s1 == s5); // true s5 refrences the same object as s1 and s2

        // the immutability pf strings
        // strings are immutable ( their values cannot be changed once instantiated)
            // implicitly thread safe as a result

        String s6 = "hello";
        s6.concat(". world!");

        System.out.println(s6);

        s6 = s6.concat(". world!");
        System.out.println(s6);

        String s7 = "hello. world!";
        System.out.println(s6 == s7); // false
        System.out.println(s6.equals(s7)); // true

        //s6 = s6.intern();
        //System.out.println(s6 == s7); //true

        String s8 = "hello" + ". world!";
        System.out.println(s6 == s8); // false (without interning s6 because s6 is outside the pool while s8 is

        System.out.println(s7 == s8); // true

        //---------------------------------------------------------------
        System.out.println("------------------------------------");

        Integer i1 = new Integer(127);
        Integer i2 = new Integer(1227);
        System.out.println(i1 == i2); // explicit use of the new keyward makes these seperate objects

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);

        Integer i7 = -128;
        Integer i8 = -128;
        System.out.println(i7 == i8);

        System.out.println("------------------------------------");

        /*
        StringBuilder and StringBuffer
            StringBuilder
                it does not extend the sting class
                mutable
                cannot be instantiated using string literals
                not thread safe

            StringBuffer
                it does not extend the sting class
                mutable
                cannot be instantiated using string literals
                thrread safe ( slower than stringbuilder as a result


         */

        // StringBuilder sb1 = "Does not word";
        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println(sb2 == sb3); // false
        System.out.println(sb2.equals(sb3)); // false because for some reason string builder and buffer do not ovverride the .equals method from object

        sb2.append(". wolrd!");
        System.out.println(sb2);

        String s9 = sb2.toString();
        System.out.println(s7 == s9); // false






    }
}
