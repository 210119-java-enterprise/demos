package com.revature;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
    TLDR:
        - autoboxing and unboxing while not always expensive, can be if we do it a lot
        - java.util.function package provides "primitive" functional interfaces to avoid
          this performance loss.
 */
public class PrimitiveFunctionDriver {

    public static void main(String[] args) {

        Supplier<Integer> integerSupplier = () -> 10; // <- that 10, gets autoboxed into an Integer

        // here that autoboxed Integer is now unboxed back into a primitive int
        int i1 = integerSupplier.get();
        System.out.println("i1 = " + i1);

        // No inheritance relationship between primitive-functional interfaces and the main types
        IntSupplier intSupplier = () -> 10;
        int i2 = intSupplier.getAsInt();
        System.out.println("i2 = " + i2);

        DoubleToIntFunction doubleToIntFunction = value -> (int) Math.floor(value);
        int e = doubleToIntFunction.applyAsInt(2.71828);
        System.out.println("e = " + e);

    }
}
