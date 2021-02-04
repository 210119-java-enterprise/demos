package com.revature;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;



/*

 */
public class PrimitiveFunctionDriver {

    public static void main(String[] args){
        Supplier<Integer> integerSupplier = () ->10; //<-that 10, gets autobox4ed into an Integer
        //VV here that autoboxed Integer is now re-converted back into a primitive int
        int i1=integerSupplier.get();
        System.out.println("i1= "+integerSupplier);

        //No inheritace relationship between primitive-functional interfaces and the main types
        IntSupplier intSupplier= ()->10;
        int i2=intSupplier.getAsInt();
        System.out.println("i2= "+intSupplier);


        DoubleToIntFunction doubleToIntFunction=value -> (int)Math.floor(value);
        int e=doubleToIntFunction.applyAsInt(2.71828);
        System.out.println("e= "+e);
    }
}
