package com.revature;

import com.revature.arrays.ArrayDemo;
import com.revature.overloading.MethodOverloader;

public class Driver {

    public static void main(String[] args){

        ArrayDemo arraydemo=new ArrayDemo();
        arraydemo.learningArrays();

        MethodOverloader methodOverloader=new MethodOverloader();

       // methodOverloader.test(new Integer(1));
        methodOverloader.test(1,2,3,4);

    }
}
