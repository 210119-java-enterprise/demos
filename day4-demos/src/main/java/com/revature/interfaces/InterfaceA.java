package com.revature.interfaces;

public interface InterfaceA {

    /*
    * abstract data types
    * do not have constructors
    * methods with no body
    * variables are implicitly public, static, final
    *
    * - interfaces extend other interfaces (multiple inheritance is allowed here)
    *  - interfaces cannot implement/extend classes
    *  - classes implement interfaces
    *
    *  - an interface with one and only one abstract method is known as a "functional interface"
    *
    * - an interface that has no declared methods is a marker interface
    * */

    int value = 10;
    void method1();

    // add in Java 8 for backwards compatibility
    default void method2(){
        System.out.println("interface method with a default implementation!");
    }


}
