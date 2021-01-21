package com.revature.arrays;

import com.revature.Driver;

import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo() {
        super();
    }

    public ArrayDemo(String someValue){
        this.someValue = someValue;
    }

    public void learningArrays() {

        boolean dontRun = false;

        if (dontRun) {
            // void methods cant return values, but you can stil; use them to return keywors}
            return;
        }
        // Array declaration

        // int[] arr = new int[5];
        // int []arr = new int[5];
        // int arr[] = new int[5];

        // int[] arr = {0, 2, 7, 4, 11}; <---- array literal notation
        // arrays are of fixed size in java, meaning that once
        // instantiated (creatied) their size cannot be changed
        Object[] arr = {2, 3.0, 4, "works", new Driver()};
        Object o1 = arr[3];
        String o2 = (String) arr[3]; // explicit casting
        // String o3 = (String) arr[4]; // throws an error
        //System.out.println(03);

        // this works too
        String o3 = arr[4].toString(); // not the same as casting
        System.out.println(o3);

        System.out.println("string representation: " + arr);

        System.out.println("show numbers: " + Arrays.toString(arr));

                int[] intArray = {432, 72, 24, 42, -5, 0};
        System.out.println(Arrays.toString(intArray));


        System.out.println(intArray[0]);
        intArray[0] = 7861;
        System.out.println(intArray[0]);
        System.out.println(intArray[intArray.length - 1]);
        System.out.println(intArray.length);

        // Technically you can make an array of objects, but this comes with some challange when accessing them
for (int i = 0;i < intArray.length; i++){
    System.out.println(intArray[i]);
}

System.out.println("------------------");
    for (int value : intArray){
        System.out.println(value);
    }

        System.out.println("------------------");

    String[] strings = {"this", "is", "an", "Array", new String("literal")};
    printValues(strings);

    int[] newInts = {1, 2, 3};
    int[] otherInts = Arrays.copyOf(newInts, newInts.length);

   if (arr[4] instanceof String) {
       System.out.println((String) arr[4]);
   } else {
       System.out.println("not a string");

   }
        System.out.println("------------------");

 // this way  int[][] multiArray = new int[3][5];
  // or
        int[][] multiArray = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        }

        private void printValues(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);

            }
        }
            private void printValues(String[] arr) {
                for (int i = arr.length - 1; i >=  0; i--) {
                    System.out.println(arr[i]);

                }
            }
}


