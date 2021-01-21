package com.revature.arrays;

import com.revature.Driver;
import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo(){
        super(); //not actually required. Added implicitly.
    }

    public ArrayDemo(String value){
        someValue = value;
    }

    public static void learningArrays() {

        boolean dontRun = false;

        if (dontRun) {
            return; // ends the method early if the condition is true.
        }

        /**
         * This is a JavaDoc comment. Multi-line. Begins with **.
         * We use these for adding documentation to methods, fields, and classes.
         */

        /*
            Array declarations
            int[] arr = new int[5];
            int[] arr = {1,1,2,3,5}; <-- array literal notation

            Arrays are of fixed size in Java, meaning that once
            instantiated (created) their size cannot be changed.
         */

        // Technically you can make an array of Objects, but this comes with some challenges when accessing members
        Object[] arr = {2,3.0,5,"works", new Driver()};
        //String 01 = arr[3]; doesn't work. Java sees this element as an Object
        String o2 = (String) arr[3]; // explicit casting as a String
        //String o3 = (String) arr[4]; // throws a RunTimeException because Driver cannot be cast to a String
        //System.out.println(o3);

        // System.out.println() == sout shortcut.
        System.out.println("String representation: " + arr); // not super useful, doesn't show members.
        System.out.println("Show Members: " + Arrays.toString(arr));

        /*
            Accessing and manipulating array values

            - Java arrays start with an index position of 0
                + An array with 5 values in it will have positions 0-4

            - Use "bracket notation" to access array values by their index position.
         */
        int[] intArray = {1,1,2,3,5};
        System.out.println(intArray[0]);
        intArray[0] = 7777;
        System.out.println(intArray[0]);

        // throws an ArrayIndexOutOBoundsException for any value that is out of the index range.
        //System.out.println(intArray[-1]);
        //System.out.println(intArray[6]);

        int[] intArray1 = {756, 111224, -3, 556, 43};
        Arrays.sort(intArray1);
        // Easy access to last value in case you don't know the size of the array.
        System.out.println(intArray1[intArray1.length - 1]);

        // traditional for loop to print each member of the array.
        for(int i = 0; i < intArray1.length; i++) {
            System.out.println(intArray1[i]);
        }

        printValues(intArray1);

        // enhanced for loop (for-each)
        // NOTE: no access to index positions
        for(int value : intArray1){
            System.out.println(value);
        }

        String[] strings = {"this", "is", "an", "array"};
        printValues(strings);

        // remember that arrays are if a fixed size that cannot be changed,
        // but can be copied into a new array. Arrays utility class provides the copyOf method.
        int[] newInts = {1,2,3};
        int[] otherInts = Arrays.copyOf(newInts,newInts.length + 1);
        System.out.println(newInts.length);
        System.out.println(otherInts.length);

        int[][] multiArray = new int[3][3];
        /*
            [
                [#,#,#]
                [#,#,#]
                [#,#,#]
            ]
         */

        int[][] multiArrayliteral = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        // Iterate across the multidimentional array, use nested for loops
        for(int i = 0; i < multiArrayliteral.length; i++){
            for(int j = 0; j < multiArrayliteral[i].length; j++){
                System.out.println("Value: " + multiArrayliteral[i][j]);
            }
        }

    }

    // Method Overloading. Methods that have the same name, but different return types and parameters (datatypes / amounts)
    // Compile time polymorphism, because the method can be determined using the values you pass into method call.
    private static void printValues(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void printValues(String[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }


}
