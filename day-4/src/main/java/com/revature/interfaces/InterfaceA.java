package com.revature.interfaces;

public interface InterfaceA {
    int value=10;//implicitly public static final
    void method();//implicitly abstract

    //add in java 8 for backwards compatability

    default void method2(){
        System.out.println("interface method with a default implementation!");
    }

    //Java as pretty much always allowed for interface to have static methods
    static void method3(){
        System.out.println("I cannot be overridden, but I can be shadowed/redeclared!");

    }
}
