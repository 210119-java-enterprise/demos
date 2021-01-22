package com.revature.interfaces;

//no constructors
//interface extend other interfaces
//interfaces cannot extend classes
//classes can implement multiple interfaces
public interface InterfaceA {

    //all variables are implicitly public, static and final
    int value = 5;

    void method();//implicitly public nad abstract

    //added in Java 8 for backwards compatibility
    default void method2(){
        System.out.println("Interface method with default implementation");
    }

    static void method3(){
        System.out.println("I cannot be overridden, but I can be shadowed/re-declared!");
    }
}
