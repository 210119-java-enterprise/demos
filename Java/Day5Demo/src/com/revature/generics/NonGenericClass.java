package com.revature.generics;

public class NonGenericClass {

    Object instance;

    Object[] objArray;

    public NonGenericClass(Integer integer) {
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public static void main(String[] args) {
        NonGenericClass ngc = new NonGenericClass(new Integer(9));
     //   ngc[0] = new Integer(18);

        for (int i =0; i <ngc.objArray.length; i++){
            if(ngc.objArray[i] instanceof Integer){
                System.out.println(((Integer) ngc.objArray[i]).floatValue());
            }
        }
    }
}
