package com.revature.strings;


public class StringDriver {
    public static void main(String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;
        //String pool is a special area inside heap memory that Java leverages to store String objects with unique values
        //not all strings are stored in string pool: using new or returned from String API method

        Integer i1 = 128;
        Integer i2 = -129;
        System.out.println(i1==i2);
        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");

    }
}
