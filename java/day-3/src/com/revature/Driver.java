package com.revature;

import com.revature.arrays.ArrayDemo;
import com.revature.methodoverloading.Overloading;

public class Driver {

    public static void main(String[] args)
    {

        ArrayDemo arr = new ArrayDemo();

        arr.learningArrays();

        Overloading ov = new Overloading();

        ov.test(new Integer(1));
        ov.test(1, 3, 6, 4);
    }
}
