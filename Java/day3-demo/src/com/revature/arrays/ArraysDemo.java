package com.revature.arrays;

import com.revature.Driver;

import java.sql.SQLOutput;

public class ArraysDemo {

    String someValue;

    public ArrayDemo{
        super();
    }
    public ArraysDemo(String Value) {
        this.someVaule = someValue;
    }
    /**multi line comment used for adding documentation to methods
     fields, classes, etc

     */
    public void learningArrays() {
        boolean dontRun = false;
        if (dontRun) {
            return; //void methods cannot return values
        }
        /*arrays declaration
        all legal methods, choose pref

        int[] arr = new int[5];
        int []arr = new int[5];
        int arr[] = new int[5]; <- these 3 start array with all 0s

        int[] arr ={2, 3, 5, 7, 11}; <- array with actual values

        arrays are of fixed size in java, meaning that
        once instantiated (created) their size cannot be changed.
        can  bypass this by making a copy of the array and placing
        in bigger array

         */
        Object[] arr ={2, 3.0, 5, "works", new Driver()};
        //String o1 = arr[3]; //doest work, java sees this element as an object not a string
        Object o1 = arr[3];
        String o2 = (String) arr[3]; //casting method
        String o3 = arr[4].toString(); // not the same as casting
        System.out.println(o3);
        System.out.println(); //sout is shortcut for system.out.println
        System.out.println("string representation: " + arr);
        /*System.out.println("Show members: " + Arrays.toString(arr));

        int[] intArray = {423, 72, 24,42, -5, 0};
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString);
        //easy code for last element in unknown size
        System.out.println(intArray[intArray.length -1]);
        //prints all numbers in array
        for(int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);

        }*/
        int[][] multiArray = new int[3][4];
        /*
        [
            [0, 0, 0, 0],
            [0, 0, 0, 0],
            [0, 0, 0, 0]
        ]
        to itterate across use nested for loops
         */
        for (int y = 0; y < multiArray.length; y++) {
            for (int x = 0; x < mulitArray[i].length; x++) {
                System.out.println("Value:" + multiArray[y][x]);
            }

        }
    }

    //method overloading
    //diff parameters
    //compile time polymorphism

    private void privateValues(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    private void privateValues(String[] arr){
        for(int i = arr.length - 1; i >= 0; i++){
            System.out.println(arr[i]);
        }
    }
    private void printValues(Object[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        }
    }
}
