package com.revature.arrays;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo(){

    }

    public ArrayDemo(String someValue){
        this.someValue = someValue;
    }

    /**
     * this is a  JavaDoc comment. it is multiline
     *
     */
    public void learningArrays(){
        boolean dontRun = false;
        if(dontRun){
            // void methods cannot return values,
            // but you can still use the return keyword
            return; // ends the method early if condition is true
        }

        /*
            Arrays declaration

                int[] arr = new int[5];
                int []arr = new int[5];
                int arr[] = new int[5];

                // this will start the array
                //with the values inside as
                //opposed to the above ones
                //which all start at 0

                int[] arr = {2,3,5,7,11};  -- array literal notation

                Arrays are of fixed size in Java, meaning that once
                instantiated (created) their size cannot be changed

         */

        //System.out.println(Arrays.toString(arr)); // actually shows members

        int[] intArray = {423,72,24,42,-5,0};
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));


        /*
            Accessing and manupulating array values

                -Java arrays start with an index position of 0
                    - An array with 6 values in it will have positions 0-5
                - use "bracket notation" to access array values by their index position.
         */
        System.out.println(intArray[0]);
        intArray[0] = 7861;
        System.out.println(intArray[0]);


    //    System.out.println(intArray[-1]);


        // easy access to last value incase you dont know how many values are in the array
        System.out.println(intArray[intArray.length-1]);
        System.out.println(intArray.length);

        // traditional for loop to print each member of the array
        for(int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }

        for(int value : intArray){
            System.out.println(value);
        }

        System.out.println("+----------------+");

       // String strings = {"this", "is", "an", "array", new String("literal")};
       // printValues(strings);
    }

    /*
        Method overloading
            -- methods that have the same name but different return types or parameters
                -- could have fewer or more parameters
                -- could have parameters of different data types

            -- compile-time (static) polymorphism
                -- compile-time, because the method that you will use will be determined at
                compile time based on the values you pass into the method call
     */

    private void printValues(int[] arr){
        for (int i = 0; i <arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    private void printValues(String[] arr){
        for(int i = arr.length-1; i >=0; i--){
            System.out.println(arr[i]);
        }
    }



}
