package day3demo;

import java.util.Arrays;

public class ArrayDemo {
    String somevalue;
    public ArrayDemo() {
        super();
    }

    public ArrayDemo(String somevalue) {
        this.somevalue = somevalue;
    }

    /**
     * JavaDoc comments start with /** and starts on second line
     * Used to add documentation for methods, fields and classes
     */
    public void learningArrays() {
        boolean dontrun = false;

        if (dontrun) {
            return;
        }

        int [] arr0 = new int[5]; // {0, 0, 0, 0, 0}
        int [] arr1 = {0, 1, 5, 3, 4}; // array literal notation
        // Arrays are fixed size
        // Arrays must be of the same type

        // Can use "sysout" as a shortcut for System.out.println();

        // Arrays utility class has lots of helpful methods
        System.out.println(Arrays.toString(arr0));
        System.out.println(Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        // for-each or enhanced loops
        // no index access
        for (int value : arr1) {
            System.out.print(value + "\t");
        }

        // Can use Arrays class to increase length of array with copyOf method
        int[] arr2 = Arrays.copyOf(arr1, 10);
        System.out.println("\n" + Arrays.toString(arr2));

        // Use instanceof to make sure object is expected type
        Object[] arr3 = new Object[] {1, "Hello there.", 2.5};
        if (arr3[1] instanceof String) {
            System.out.println("General Kenobi!");
        }
        if (!(arr3[0] instanceof String)) {
            System.out.println("Not a string");
        }

        // Multidimensional arrays
        int [][] arr4 = new int[2][3];
        int [][] arr5 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        arr4 = arr5;
        System.out.println(Arrays.toString(arr4));


        
    }

    private void printValues(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }

    // Method overloading, but bad practice because method logic is the same
    // If wanted to print all values of any type of array, use generics
    private void printValues(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
    
}

