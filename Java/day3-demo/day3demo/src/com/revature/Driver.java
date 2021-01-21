package com.revature;

import com.revature.arrays.ArrayDemo;
import com.revature.overloading.MethodOverloader;

public class Driver {

    public static void main(String[] args) {
        ArrayDemo arrD = new ArrayDemo();
        MethodOverloader over = new MethodOverloader();
        arrD.learningArrays();
        int a = 1;
        over.test(a);
    }
}
