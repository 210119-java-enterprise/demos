package com.revature.strings;

/*
    Topics
        - Memory management of Strings (String pool)
        - String API (Application Programming Interface) - publicly exposed behavior of Strings)
        - StringBuilder/StringBuffer classes (less emphasis on StringBuffer)
 */

public class StringDriver {

    public static void main(String[] args) {

        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            String Pool

                - A special area inside of heap memory that Java leverages to store String objects
                  with unique values. (implements the Flywheel design patter)
                - Not all Strings are stored in the String pool
                    + if you explicitly use the "new" to instantiate the string.
                    + Strings that are returned from any String API method are not in the pool

                - If you use literal notation with the same value as an existing String, a single
                String object will be stored in the pool.
         */

        System.out.println(s1 == s2); // true; since we created 2 string literals
                                        // with the same value
                                        // these refs point to same obj

        System.out.println(s1 == s3); // false; s3 was explicitly "new".

        System.out.println(s1.equals(s3)); // true; are checking value equivalence

        /*
            String interning is the act of moving a String obj - which exists
            outside of the String pool and "interning" or moving it into the
            String pool.
         */

        String s5 = s3.intern();
        System.out.println(s1 == s3); // false. s3 technically didn't get interned, the method returned an interned String
        System.out.println(s2 == s3); // also false
        System.out.println((s1 == s5)); // true, s5 references the same obj as s1 & s2

        /*
            The immutability of Strings

            - Strings are immutable (their value cannot be changed once instantiated)
                + implicitly thread-safe as a result
         */

        String s6 = "hello";
        s6.concat(", world!");
        System.out.println(s6); // result of .concat returns a new String and we just ignored it.

        s6 = s6.concat(", world!");
        System.out.println(s6);

        String s7 = "hello, world!";
        System.out.println(s6 == s7); // since s6 used .concat String API method, it is not in the String Pool
        System.out.println((s6.equals(s7)));

        String s8 = "hello" + ", world!";
        System.out.println(s6 == s8); // false, s6 is outside of pool.
        System.out.println(s7 == s8); // true, s8 is inside of the pool.

        //-----------------------------------

        System.out.println("==========================");

        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2); // explicit use of new keyword makes these separate objects

        Integer i3 = 127; //auto-boxing
        Integer i4 = 127;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);

        Integer i7 = -128;
        Integer i8 = -128;
        System.out.println(i7 == i8); // Integers in byte value range, there is an "integer pool" where they refer to
                                        // same value in memory

        System.out.println("==============================");

        /*
            StringBuilder and StringBuffer

                StringBuilder
                    - it does NOT extend the String class
                    - mutable
                    - cannot be instantiated using String literals
                    - not thread-safe

                StringBuffer
                    - same as StringBuilder
                    - is thread-safe (slower as a result)
         */

        // StringBuilder sb1 = "Does not work"
        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println(sb2 == sb3); // both false
        System.out.println(sb2.equals(sb3)); // Object class default .equals method is ==
        // StringBuilder/Buffer do not override the .equals method

        sb2.append(", world!");
        System.out.println(sb2); // StringBuilder/Butter objects are mutable.

        String s9 = sb2.toString();
        System.out.println(s9);
        System.out.println(s7 == s9); // false

        // reverse a string.
        String s10 = "";
        for(int i = s9.length()-1; i >= 0; i--){
            s10 += s9.charAt(i);
        }

        System.out.println(s10);



    }

}
