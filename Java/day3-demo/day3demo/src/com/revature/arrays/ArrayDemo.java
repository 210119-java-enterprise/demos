package com.revature.arrays;

import com.revature.Driver;

public class ArrayDemo {

    String someValue;

    public ArrayDemo() {
        super();
    }

    public ArrayDemo(String someValue) {
        this.someValue = someValue;
    }

    /**
     * JavaDoc comment
     */
    public void learningArrays(){
       // Line comment
       /*
            Multi line comment
            int[] arr = new int[5];
            int []arr = new int[5];
            int arr[] = new int[5];

            int[] arr = {2,3,5,7,11} // array literal notation
        */
       int[] intArray = {1,2,3,4,5};
       // Traditional for loop to print each member of the array
        printValues(intArray);

        //for-each loop
        //note: no access to index positions
        for (int value : intArray) {
            System.out.println(value);
        }

        String[] strings = {"this", "is", "a", "string", new String("literal")};
        printValues(strings);

        System.out.println("+--------------------------------");

        Object[] arr = {2, 3.0, 5, "works", new Driver()};

        Object o1 = arr[3];

        if (arr[4] instanceof String) {
            System.out.print((String) arr[4]);
        } else {
            System.out.println("arr[4] is not a String");
        }

        System.out.println("+--------------------");

        //int[][] multiArray = new int[3][5];
        /*
            [
                [#, #, #, #, #],
                [#, #, #, #, #],
                [#, #, #, #, #]
               ]
         */

        int[][] multiArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Iterate across the multidimensional array, use nested for-loops
        for (int i=0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.println("Value at ("+i+", "+j+") : "+ multiArray[i][j]);
            }
        }
    }

    /*
        Method overloading done with this and the next method.

            -methods have the same name, but differing return or parameters

           - compile-time (static) polymorphism
                + compile-time because the method that you will use can be determined at compile time based on the
                values you pass into the method call.
     */
    private void printValues(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    private void printValues(String[] arr) {
        for (int i = arr.length -1; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
    }
}
