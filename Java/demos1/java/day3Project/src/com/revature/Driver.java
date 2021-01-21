package com.revature;

import com.revature.arrays.ArrayDemo;
import com.revature.overloading.MethodOverloader;

public class Driver {
    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.learningArrays();

        MethodOverloader methodOverloader = new MethodOverloader();
        methodOverloader.test(1);
    }
}
