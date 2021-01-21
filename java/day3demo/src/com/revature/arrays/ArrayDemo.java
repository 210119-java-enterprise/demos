package com.revature.arrays;

import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo(){
        super();
    }

    public ArrayDemo (String value){
        this.someValue = value;
    }

    public void learningArrays(){

        int[] intArray = {300, 302, 52, -10, 0};
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        int[] largerIntArray = Arrays.copyOf(intArray, 8);
        int[] smallerIntArray = Arrays.copyOf(intArray, 3);

        System.out.println(Arrays.toString(largerIntArray));
        System.out.println("+-----------------+");
        System.out.println(Arrays.toString(smallerIntArray));
    }
}
