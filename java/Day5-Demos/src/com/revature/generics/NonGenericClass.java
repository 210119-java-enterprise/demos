package com.revature.generics;

import java.util.LinkedList;
import java.util.List;

public class NonGenericClass {
    Object instance;
    List objects;
    Object[] objArray;

    public NonGenericClass(Object instance){
        this.instance=instance;
    }







    public static void main(String[]args){
        NonGenericClass ngc = new NonGenericClass(new Integer(9));
        ngc.objects=new LinkedList();
        ngc.objArray=new Object[10];
        ngc.objArray[0]=new Integer(10);
        ngc.objArray[0]=new Integer(2);
        ngc.objArray[0]=new Integer("hello world");
        for (int i = 0; i < ngc.objArray.length ; i++) {
            if(ngc.objArray[i] instanceof Integer){
                System.out.println(((Integer) ngc.objArray[i]).floatValue());
            }
        }

    }



}
