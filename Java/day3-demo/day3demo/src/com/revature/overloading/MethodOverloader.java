package com.revature.overloading;

public class MethodOverloader {

    public void test(int a) {
        System.out.println("int: "+a);
    }

    public void test(Integer a) {
        System.out.println("Integer: "+a);
    }

    // variable arguments are treated as an array
    public void test(int... a) {
        System.out.println("variable arguments: "+a);
    }

    public void test(double a) {
        System.out.println("double: "+a);
    }
}
