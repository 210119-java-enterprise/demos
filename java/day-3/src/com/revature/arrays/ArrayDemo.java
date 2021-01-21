package com.revature.arrays;

import com.revature.Driver;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDemo {
    String someValue;

    public  ArrayDemo(){
        super();
    }

    public ArrayDemo(String value)
    {
        this.someValue = value;
    }

    /**
     *  JavaDoc comment
     *  use to summarize methods, classes, etc.
     */
    public void learningArrays() {
        //int[] arr = new int[5];

        Object[] arr = {2, 34, "hello", new Driver()};
        //String o1 = arr[3]; //doesn't work Java sees as object

        Object o1 = (String) arr[2]; //sees as an object and casts to string
        System.out.println(o1);

        System.out.println("Show members: " + Arrays.toString(arr)); //array util class

        int[] intArr = {23, 4, 12, 1, 54};

        System.out.println("regular arr: " + Arrays.toString(intArr));

        Arrays.sort(intArr); //sort actual array

        System.out.println("sorted intArr: " + Arrays.toString(intArr));

        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }

        //for-each loop
        //note no access to index here
        for (int value : intArr) {
            System.out.println(value);
        }

        //Copy arr using arr util
        int[] newInts = {1, 2, 3};
        int[] otherInts = Arrays.copyOf(newInts, newInts.length + 1); // copy of old arr + 1 to size

        //conditionalize the operation to ensure the value of some index is some expected type
        if (arr[3] instanceof String) {
            System.out.println((String) arr[3]);
        } else {
            System.out.println("not string");
        }

        int[][] multiarr = {
                {1, 3, 4},
                {3, 4, 5},
                {1, 3, 6}
        };

        for (int i = 0; i < multiarr.length; i++)
        {
            for(int j = 0; j < multiarr[i].length; j++)
            {
                System.out.println("value at: " + i + " "+ j + " is " + multiarr[i][j]);
            }
        }
    }

    private void printValues(int[] arr)
    {
        for(int i  =0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }

    private void printValues(String[] arr) //method overloading that have same name but different return type or params
    {
        for(int i  =0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}
