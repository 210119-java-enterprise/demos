package com.revature.arrays;

public class ArrayDemo {
    String value;
    public ArrayDemo(){
        super();
    }
    public ArrayDemo(String value){
        this.value = value;
    }

    /** JavaDoc Comment


     */
    public void learningArrays(){
        boolean dontRun = false;
        if(dontRun){
            return;
        }

        // Array Declarations
        /*
        int[] arr = new int[5];
        int []arr = new int[5];
        int arr[] = new int[5];

        int[] arr = {4,3,4,5,5} array literal notation
        arrays are fixed size in java meaning once instantiated (they are objects) their size cannot be changed
         */

        int[] arr = {1,3,4,5,6};//new int[5];
        printArray(arr);
        int i = new Integer(new Integer(3));
        System.out.println(i);
    }


    public static void main(String[] args){
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.learningArrays();
    }

    public void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public void test(String x){

    }
}
