package com.revature.overloading;

import java.util.Arrays;

public class MethodOverloading {

    public void test(int i){
        System.out.println("int: " + i);
    }

    public void test(Integer i){
        System.out.println("Integer: " + i);
    }

    /**
     * This passes multiple variables, 0 -> n
     * @param i the "array" of variables
     */
    public void test(int... i){
        System.out.println(Arrays.toString(i));
    }
}
