package com.revature.Overloader;


import java.util.arrays;

public class MethodOverloader {

    public void test(int i) {
        System.out.println("int: " + i);
    }

    public void test(Integer i) {
        System.out.println("Integer: " + i);
    }

    // Variable arguments (can take in 0 or more params)
    // technicall varargs can be used as an array (because they are!)
    public void test(int... ints) {
        if (ints.length >= 3) {
            System.out.print("variable arguments: " + ints[2]);
        } else {
            System.out.println("ints.length is not >= to 3");
        }
    }

    public void test(double d) {
        System.out.println("double: " + d);
    }

    public void test2(int[] ints) {
        System.out.println("int array: " + Arrays.toString(ints));
    }
}