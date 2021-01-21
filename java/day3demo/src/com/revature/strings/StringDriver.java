package com.revature.strings;

public class StringDriver {

    public static void main(String[] args){

        /*
            == is looking at reference
            .equals is looking at value
         */

        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s3)); //true

        String s5 = s3.intern();//intern returns a new string, so s5 references inside string pool but
                                //s3 is still outside the string pool
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s5); //true
        s3 = s5;
        System.out.println(s1 == s3);//true

        //String immutability
        System.out.println("+----------------+");

        String s6 = "hello";
        s6.concat(", world!");
        System.out.println(s6);//prints hello
        s6 = s6.concat(", world!");
        System.out.println(s6);

        String s7 = "hello, world!";
        System.out.println(s6 == s7);//false
        System.out.println(s6.equals(s7));//true

        String s8 = "hello" + ", world!";
        System.out.println(s6 == s8);//false
        System.out.println(s7 == s8);//true

        System.out.println("+------------------+");

        /*
            StringBuilder and StringBuffer have the same methods
            StringBuffer is thread-safe
         */

        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println(sb2 == sb3);//false
        System.out.println(sb2.equals(sb3));//false

        sb2.append(", world!");
        System.out.println(sb2);
        String s9 = sb2.toString();
        System.out.println(s7 == s9);//false
    }
}
