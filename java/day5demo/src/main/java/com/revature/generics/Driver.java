package com.revature.generics;

public class Driver {
    public static void main(String[] args) {
        NonGenericClass ngc = new NonGenericClass(new Integer(9));
        ngc.objArray = new Object[10];
        ngc.objArray[0] = new Integer(18);
        ngc.objArray[1] = new String("Hello there");
        System.out.println(ngc.objArray[0]);

        // ngc.objArray[i+1] != null checks that next item isn't null
        for (int i = 0; i < ngc.objArray.length && ngc.objArray[i+1] != null; i++) {
            // Need to type check because each item in an Object
            if (ngc.objArray[i] instanceof Integer) {
                System.out.println(((Integer) ngc.objArray[i]).floatValue());
            } else if (ngc.objArray[i] instanceof String) {
                System.out.println((String) ngc.objArray[i] + "\nGeneral Kenobi!");
            }
        }


        GenericClass<Integer> gc = new GenericClass<>(7);
        gc.objArray = new Integer[10];
        gc.objArray[0] = 54;
        System.out.println(gc.objArray[0]);
        for (int i = 0; i < gc.objArray.length && ngc.objArray[i+1] != null; i++) {
            // No need to type check, we know it will only be Integers
            System.out.println(gc.objArray[i].floatValue());
        }

    }
}
