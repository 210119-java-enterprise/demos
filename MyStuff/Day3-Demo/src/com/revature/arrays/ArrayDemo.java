package com.revature.arrays;

import com.revature.Driver;

import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo() {
        super(); // remember: not actually required, is added implicitly
    }

    public ArrayDemo(String someValue) {
        this.someValue = someValue;
    }

    /**
     * This is a JavaDoc comment. It is multi-line, but begins with /** and ends like
     * a regular multi-line comment.
     *
     * We use these for adding documentation to methods, fields, or classes
     */
    public void learningArrays() {

        boolean dontRun = false;

        if (dontRun) {
            // void methods cannot return values, but you can still use the return keyword
            return; // ends the method early if the condition is true
        }

        /*
            Arrays declarations
                int[] arr = new int[5];
                int []arr = new int[5];
                int arr[] = new int[5];
                int[] arr = {2, 3, 5, 7, 11}; <--- array literal notation
                Arrays are of fixed size in Java, meaning that once
                instantiated (created) their size cannot be changed.
         */

        int[] intArr = {1, 2, 3};
        // I call "System.out.println()", "sysout". IDE shortcut = sout
        System.out.println("String representation: " + intArr);// no super useful, doesnt show members

        // Arrays utility class contains several useful static members (fields/methods) for working with array types
        System.out.println("Show members: " + Arrays.toString(intArr)); // works differently, actually shows members

        int[] intArray = {423, 72, 24, 42, -5, 0};
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        /*
              Accessing and manipulating array values
                - Java arrays start with an index position of 0
                        + An array with 6 values in it will have index positions: 0 - 5
                - Use "bracket notation" to access array values by their index position.
         */
        System.out.println(intArray[0]);
        intArray[0] = 7861;
        System.out.println(intArray[0]);

        // throws an ArrayIndexOutOfBoundsException for any value that is out of the index range: 0 - 5
//        System.out.println(intArray[-1]);
//        System.out.println(intArray[6]);

        // Easy access to last value in case you don't know how many values are in the array
        System.out.println(intArray[intArray.length - 1]); // .length gives us the # of members in the array
        System.out.println(intArray.length);

        // traditional for loop to print each member of the array
        printValues(intArray);

        System.out.println("+-------------+");

        // for-each loop
        // NOTE: no access to index positions
        for (int value : intArray) {
            System.out.println(value);
        }

        System.out.println("+-------------+");

        String[] strings = {"this", "is", "an", "array", new String("literal")};
        printValues(strings);

        // Remember that arrays are of a fixed size that cannot be changed, BUT can be copied into a new array
        // The Arrays utility class provides the copyOf method for doing this easily
        int[] newInts = {1, 2, 3};
        int[] otherInts = Arrays.copyOf(newInts, newInts.length + 1);
        System.out.println("newInts array length: " + newInts.length);
        System.out.println("otherInts array length: " + otherInts.length);
        System.out.println(Arrays.toString(otherInts));

        System.out.println("+------------------+");

        // Technically you can make an array of Objects, but this comes with some challenges when accessing members
        Object[] arr = {2, 3.0, 5, "works", new Driver()};
//        String o1 = arr[3]; // doesn't work? Java sees this element as an Object
        Object o1 = arr[3];
        String o2 = (String) arr[3]; // explicit casting
//        String o3 = (String) arr[4]; // throws a ClassCastException because Driver cannot be cast to a String
//        System.out.println(o3);
        String o3 = arr[4].toString(); // works fine, because we are using .toString() [not the same as casting]
        System.out.println(o3);

        // conditionalize the operation to ensure that the value at some index is of some expected type
        if (arr[4] instanceof String) {
            System.out.println((String) arr[4]);
        } else {
            System.out.println("arr[4] is not a String");
        }

        System.out.println("+-----------------+");

//        int[][] multiArray = new int[3][5];
        int[][] multiArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Iterate across the multidimensional array, use nested for-loops
        for (int y = 0; y < multiArray.length; y++) {
            for (int x = 0; x < multiArray[y].length; x++) {
                System.out.println("Value at (" + y + ", " + x + "): " + multiArray[y][x]);
            }
        }

    }

    /*
        Method overloading
            - methods that have the same name, but differing parameters (return type can also be changed, only if
                the parameters are also different
                    + could have fewer or more parameters
                    + could have parameters of different data types
            - compile-time (static) polymorphism
                    + compile-time, because the method that you will use can be determined a compile time based on the
                        values you pass into the method call
     */
    private void printValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void printValues(String[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }




}