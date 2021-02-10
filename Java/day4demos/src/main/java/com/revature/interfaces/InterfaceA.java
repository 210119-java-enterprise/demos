package com.revature.interfaces;

/*
    Interfaces
        - are abstract data types (cannot be instantiated)
        - do not have constructors
        - methods with no body (method stubs) are implicitly abstract
        - variables declared within are implicitly public, static, and final
        - since Java 8, you can have what are called "default" methods
            + methods that have a default implementation (that can be overidden)

        - interfaces extend other interfaces (multiple inheritance is allowed here)
        - interfaces cannot implement/extend classes
        - classes implement interfaces

        - an interface with one and only one abstract method is known as a "functional interface"
        - an interface that has NO declared methods is known as a "marker interface"
 */
public interface InterfaceA {
    int value = 10; // implicitly public static final
    void method1(); //implicitly abstract

    // added in Java 8 for backwards compatibility
    default void method2() {
        System.out.println("interface method with a default implementation!");
    }

    // Java has pretty much always allowed for interface to have static methods
    static void method3() {
        System.out.println("I cannot be overridden, but I can be shadowed/redeclared");
    }
}
