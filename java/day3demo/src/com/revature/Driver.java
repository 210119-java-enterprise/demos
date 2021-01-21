package com.revature;

import com.revature.arrays.*;
import com.revature.overloading.MethodOverloading;

public class Driver {

    public static void main(String[] args){
        ArrayDemo arr = new ArrayDemo();
        arr.learningArrays();
        MethodOverloading methodOverloading = new MethodOverloading();
        methodOverloading.test(1,2,3,4);
        methodOverloading.test(1);
    }
}
