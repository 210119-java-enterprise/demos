package com.revature.strings;

import java.sql.SQLOutput;

/*
    Topics
        - memory managment of strings (string pool)
        - String API the publicly exposed behaviors of strings)
        - StringBuilder/SringBuffer classes (less emphasis on StringBuffer)

 */
public class StringDriver {
    public static void main(String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            String pool

                - A special are inside of Heap memory that java leverages to store string objects
                with unique values. (implements teh Flywheel design pattern)

                - not all strings are stored in the string pool
                    - if you explicitly use the "new" to instantiate the string
                    - strings that are returned from any string API method are not in the pool

                - If you use literal noation with the same value as an existing string, a single
                String object will be stored in the pool.



         */

        System.out.println(s1 == s2);  // true
                                        // literal notation with the same value, these
                                        // references point to the same object


        System.out.println(s1 == s3); // false since we explicitly used the "new"
                                        //keyword a new string object was created

        System.out.println(s1.equals(s3)); // true
                                            // because we are checking value equivalence

        /*
            String interning is the act of moving a string object - which exists
            outside of the string pool - and "interning" or movin it into the string pool

         */

        String s5 = s3.intern();
        System.out.println(s1 == s3);  // s3 technically didn't get interned, the method returned an interned string
        System.out.println(s2 == s3);  // also false
        System.out.println(s1 == s5);  // true  s5 references the same object as s1 (and s2)


        /*
                The immutability of Strings

                        - strings are immutable (their value cannot be changed once instantiated)
                            + implicitly thread-safe as a result

         */

        String s6 = "hello";
        s6.concat(", world!");

        System.out.println(s6); // the result of .concat returned a new string and we jstu ignored it

        s6 = s6.concat(", world!");
        System.out.println(s6);

        String s7 = "hello, world!";
        System.out.println(s6 == s7);
        System.out.println(s6.equals(s7));


        String s8 = "hello" + ", world!";
        System.out.println(s6==s8);  // false, b/c s6 exists outside the pool: where s8 is in the pool
        System.out.println(s7 == s8); // true


        //----------------------------------

        System.out.println("+-----------------+");

        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);  // explicitly use of the new keyword makes these seperate objects

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);

        Integer i7 = -128;
        Integer i8 = -128;
        System.out.println(i7 == i8);


        System.out.println("+-----------------------+");

        /*
            StringBuilder and StringBuffer

                StringBuilder
                    - it does NOT extend the String class
                    - mutable
                    - cannot be instantiated using string literals
                    - not thread-safe

                StringBuffer
                    - it does NOT extend the String class
                    - mutable
                    - cannot be instantiated using string literals
                    - is thread-safe  (slower than StringBuilder as a result)
         */

        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println(sb2 == sb3); // false
        System.out.println(sb2.equals(sb3));  // false: because for some reason, StringBuilder/Buffer do not override the .equals method from Object

        sb2.append(", world!");
        System.out.println(sb2);  // StringBuilder/Buffer objects are mutable

        String s9 = sb2.toString();
        System.out.println(s7 == s9);




    }
}
