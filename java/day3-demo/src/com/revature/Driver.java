package com.revature;

import com.revature.arrays.ArrayDemo;
import com.revature.overloading.MethodOverloading;

public class Driver {
    public static void main(String[] args) {

        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.learningArrays();

        MethodOverloading methodoverloading = new MethodOverloading();
        methodoverloading.test(new int[] {1, 2, 3, 4, 5});

    }
}
