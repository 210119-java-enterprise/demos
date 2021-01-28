package com.revature.generics;

import java.util.LinkedList;
import java.util.List;

public class GenericClass<T> {
    T instance;
    //List objects;
    T[] objArray;

    public GenericClass(T instance){
        this.instance=instance;
    }





    public static void main(String[]args){
        GenericClass <Integer> gc = new GenericClass<>(9);
        //gc.objects=new LinkedList();
        //gc.objArray=new Object[10];
        gc.objArray[0]=new Integer(10);
        gc.objArray[1]=new Integer(2);
        //gc.objArray[2]=new Integer("hello world");
        for (int i = 0; i < gc.objArray.length ; i++) {
            if(gc.objArray[i]!=null) {
                System.out.println(gc.objArray[i].floatValue());
            }
        }

    }



}
