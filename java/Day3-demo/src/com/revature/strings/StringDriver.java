package com.revature.strings;





/*
    - Memory management of Strings (String Pool)
    - String API (Application Programming Interface - the publically exposed behaviors of Strings
    - StringBuilder/StringBuffer classes (less emphasis on StringBuffer)
 */

public class StringDriver {
    public static void main(String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            String Pool

                - A special area inside of Heap memory that Java leverages to store String
                objects with unique values. (implements the Flywheel design pattern)

                - Not all Strings are stored in the String Pool
                    + if you explicitly use "new" to instantiate the String
                    + Strings that are returned from any String API method are not in the pool

                - If you use literal meanings
         */

        System.out.println(s1 == s2); // true; since we created two Strings using
        // literal notation with the same value, these references point to the same object

        System.out.println(s1 == s3); // false; since we explicitly used the "new keyword a new String object was created

        System.out.println(s1.equals(s3)); // true: because we are checking value equivalence

        /*
            String interning is the act of moving a String object - which exists outside of the String pool - and
            "interning" or moving it into the String pool
         */

        String s5 = s3.intern();
        System.out.println(s1 == s3); // s3 technically didn't get interned the method returned an interned String
        System.out.println(s2 == s3); // also false
        System.out.println(s1 == s5); // true s5 references the same object as s1 and s2

        /*
            The immutability of Strings

                - String are immutable (their value cannot be changed once instantiated)
                    + implicity thread-safe as a result
                + and concat are different
         */
        String s6 = "hello";
        s6.concat(", world!");

        System.out.println(s6); // the result of .concat returned a new String and we just ignored it

        s6 = s6.concat(", world!");
        System.out.println(s6);

        String s7 = "hello, world!";
        System.out.println(s6 == s7); // false
        System.out.println(s6.equals(s7)); // ture

        //s6 = s6.intern();
        //System.out.println(s6 == s7); // true

        String s8 = "hello" + ", world!";
        System.out.println(s6 == s8); // false bc s6 exists outside of the pool where s8 is in the pool
        System.out.println(s7 == s8); // true bc


        //------------------------------------------

        System.out.println("+---------------------------+");

        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);

        System.out.println(i1 == i2); // explicit use of the new keyword makes these seperate objects

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);

        Integer i7 = -128;
        Integer i8 = -128;
        System.out.println(i7 == i8);

        //Integer i9 = Integer.valueOf(i9);

        System.out.println("-------------------------------");

        /*
            StringBuilder and StringBuffer

            StringBuilder
                - It does not extend the String class
                - mutable
                - cannoted be instantiated using string literals
                - not thread safe

             StringBuffer
                - It does not extend the String class
                - mutable
                - cannoted be instantiated using string literals
                - is thread-safe (slower than StringBuilder as a result)
         */

        //StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println(sb2 == sb3); // false
        System.out.println(sb2.equals(sb3)); // false bc StringBuilder/Buffer doesn't override the .equals method from Object

        sb2.append(", world!");
        System.out.println(sb2); // StringBuilder/Buffer objects are mutable

        String s9 = sb2.toString();
        System.out.println(s7 == s9); // false



    }

}
