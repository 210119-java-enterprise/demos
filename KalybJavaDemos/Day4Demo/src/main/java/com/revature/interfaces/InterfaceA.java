package com.revature.interfaces;

/*
        Interfaces
            - are abstarct data types (cannot be instantiated)
            - do not have constructors
            - methods with no body (method stubs) are implicitly public and abstract
            - variables declared within are impliclitly public, static and final
            - since Java 8, you can have what are called "default" methods
                + methods that have, well a default implementation (that can be overriden)

        - interfaces extend other interfacesf (multiple inheritance is allowed here)
        - interfaces cannot implement/extend classes
        - classes implement interfaces

        - an interface with one and only one abstract method is known as a "functional interface"
        - an interface that has NO declared methods is known as a "marker interface"


 */

public interface InterfaceA {
    int value = 10; // implicitly public static final
    void method1(); // implicitly abstract
    default void method2(){
        System.out.println("interface method with a default implementation!");
    }
}
