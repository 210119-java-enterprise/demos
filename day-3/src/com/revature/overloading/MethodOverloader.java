package com.revature.overloading;

import java.util.Arrays;

public class MethodOverloader {

    public void test(int i){

        System.out.println("int: "+i);

    }
    public void test(Integer i){

        System.out.println("Integer: " + i);
    }

    public void test(int...ints){
        System.out.println("variable arguments: "+ Arrays.toString(ints));

    }

}
