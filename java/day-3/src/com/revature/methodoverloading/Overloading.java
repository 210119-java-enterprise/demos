package com.revature.methodoverloading;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Overloading {

    //can take 0 or more listed comma seperated variables and can be used as an array cause they are
    public void test(int... ints)
    {
        System.out.println("ints: "+ Arrays.toString(ints));
    }
    public void test(int i)
    {
        System.out.println("int: " + i);
    }
    public void test(Integer i)
    {
        System.out.println("integers: "+ i);
    }
}
