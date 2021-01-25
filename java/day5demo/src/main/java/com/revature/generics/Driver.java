package com.revature.generics;

public class Driver {

    public static void main(String[] args){
        NonGenericClass ngc = new NonGenericClass((new Integer(9)));
        ngc.objArray = new Object[10];
        ngc.objArray[0] = new Integer(10);
        System.out.println(ngc.objArray[0]);
        ngc.objArray[1] = "hello world";

        for(int i = 0; i < ngc.objArray.length; i++){
            if(ngc.objArray[i] instanceof Integer){
                System.out.println(((Integer)ngc.objArray[i]).floatValue());
            }
        }

        System.out.println("+--------------------+");

        GenericClass<Integer> gc = new GenericClass<>(1);
        gc.objArray = new Integer[10];
        gc.objArray[0] = 50;
        System.out.println(gc.objArray[0]);
        for(int i = 0; i < gc.objArray.length; i++) {
            if(gc.objArray[i] != null){
                System.out.println(gc.objArray[i].floatValue());
            }
        }
    }
}
