package com.revature.arrays;

import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo() {
        super();
    }


    public ArrayDemo(String someValue) {
        this.someValue = someValue;
    }

    // returns nothing because of void declaration
    public void learningArrays() {
        boolean dontRun = false;

        if (dontRun) {
            //can still use the return keyword like a break but still wont return anything.
            return;
        }
        /*
            int[] newArray = new int[5];
            int[] arr = {2, 3, 4, 5, 6};
         */

        int[] intArray = {1,3,4,5};
        int[] lessInts = Arrays.copyOf(intArray, intArray.length -1);
        Object[] arr = {2, 3.0, 5, "works", 11};
        // String o1 = arr[3]; //doesnt work because java sees this element as an object
        String o2 = (String) arr[3]; //explicit casting
        String o3 = arr[4].toString();
        System.out.println(arr[3]);
        System.out.println(arr[(arr.length - 1)]); // easy access to the last element in an array
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        // checking for type
        if (arr[4] instanceof String) {
            System.out.println((String) arr[4]);
        } else {
            System.out.println("not string");
        }

        for (int i = 0; i< intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        // if it worked it wouldnt have an index
        for (int value : intArray) {
            System.out.println(value);
        }
    }

    //overloading
    private void printValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //overloading
    private void printValues(String[] arr) {
        // reverse through list
        for (int i = arr.length; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

}
