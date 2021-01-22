package com.revature.stringDriver;


public class stringDriver {
    public static void main(String[] args) {

        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            string pool
            - a special area inside heap memory that java leverages to store string objects
            with unique values. (implements the flywheel design pattern)
            - not all strings are stored in the string pool
                - if you explicitly use the new keyword to instantiate
                - strings returned from any String api method are not in the pool
            - if you use literla notation with the same values as an existing String
         */
        System.out.println(s1 == s2);
        // true since we created 2 strings using literal notation
        // with the same value, these references point to same object
        System.out.println(s1 == s3);
        //false since s3 instantiated a new object
        System.out.println(s1.equals(s3));
        //true because it is checking the value not the reference

        String s5 = s3.intern();
        System.out.println(s1 == s3); //false s3 technically didnt get an instance, the method returned interned string
        System.out.println(s2 == s3); //s2 is same as s1, so false still
        System.out.println(s1 == s5); //true ; s5 references the same object
        /*
            - strings are immutable, value cannot be changed once instantiated
                - implecitly thread safe as a result

         */

        String s6 = "hello";
        s6.concat(", world");

        System.out.println(s6);//resust of .concat returned new string and we just ignored it
        s6 = s6.concat(", world.");
        System.out.println(s6);

        String s7 = "Hello, world";
        System.out.println(s6 == s7); //false since we used concat it returns a string and doesnt create
        System.out.println(s6.concat(s7));
        s6 = s6.intern();
        System.out.println(s6 == s7); // true

        String s8 = "hello" + ", world"; //not the same as the concat, this string is in the pool
        System.out.println(s6 == s8); // false since s6 is still oustside the string pool
        System.out.println(s7 == s8); // true since both are in the pool
    }
}
