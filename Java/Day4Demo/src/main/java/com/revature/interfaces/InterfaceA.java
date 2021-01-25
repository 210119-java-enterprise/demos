package com.revature.interfaces;


/*
Interfaces
    -abstract data types (can't be instantiated)
     -do not have constructors
     - methods with no body (method stubs) are implicitly abstract
     -variables declared within are implicitly public, static, and final
    -Since Java 8 you can have default methods (have a default implementation)
    -interfaces extend other interfaces (multiple inheritance is allowed here)
    - interfaces cannot extend/implement classes
    - classes implement interfaces

    - interfaces with one and only one abstract method is known as a "functional interface
    - interface with no declared methods is known as a 'marker interface' relic from pre java 5


 */
public interface InterfaceA {
    int value=5 ; //implicitly public static and final
    int getValue(); //implicitly abstract and public

    //added in Java 8 for backwards compatibility
    default void method2(){
        System.out.println("Hi");
    }
    // Java allows interfaces to have static methods
    static void method3(){
        System.out.println("Can not be overridden but can be shadowed or redeclared");
    }
}
