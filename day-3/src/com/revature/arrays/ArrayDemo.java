package com.revature.arrays;

import com.revature.Driver;

import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo(){
        super(); //remember:not actually required


    }

    public ArrayDemo(String someValue){
        this.someValue=someValue;

    }

    public void learningArrays(){
        boolean dontRun=false;

        if(dontRun){
            //void methods cant return values
                //but you can still use the return keyword

            return;//ends the method early if the condition is true
        }

     //   Arrays declarations
        //int arr=new int[5];
        //int [] arr=new int[5];
        //int arr[]=new int[5];
        //int arr={2,3,5,7,11};  <--array literal notation

        /*
        Arrays are of fixed size in Java, meaning that once
            instantiated(created) their size cannot be changed.


         */
        Object[] arr={2,3,0,5,"works",new Driver()};
        Object o1=arr[3];
       // Object o2=(String)arr[3];
        String o3=arr[4].toString();

        System.out.println(o3);

        System.out.println("String representation"+ arr);
        //not super usful, doesnt show members of the array

        System.out.println(Arrays.toString(arr));
        //works differently, actually shows members

        int[] intArray={432,72,24,42,-5,0};

        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        /*
        Accessing and manipulating array values
            >java arrays start an index position at 0
            >Use "bracket notation" to access array values by their index position


         */

        System.out.println(intArray[0]);
        intArray[0]=7860;
        System.out.println(intArray[0]);

        //throws an ArrayIndexOutOfBoundsException for any value that is not in the array
       // System.out.println(intArray[-1]);

        //methods that have the same name, but differing
        //return types

        /*
        compile time (static polymorphism
            +compile-time, because the method that
            +youll use can be determined a complie time
            +based on the values you pass into the method call

         */

        if(arr[4] instanceof String){
            System.out.println( arr[4]);
        }
        else {
            System.out.println("this arr is not a string");
        }



    }
    //traditional for loop to print each member of the array
        public void printvalues(int[] intArray){
            for(int i=0; i<intArray.length;i++){

                System.out.println(intArray[i]);
            }

        }
}
