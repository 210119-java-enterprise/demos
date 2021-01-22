package com.revature.interfaces;


/*
    interfaces

    are abstract data types, cant be instantiated
    do not have constructors
    mehtods with no body(method stubs) are implicitly abstract
    variables declares with in are public, static, and finaloy
    since java 8, you can have default methods,
        methods that have, well, a default implementation (can be overridden)
    interfaces can extend other interfaces (multiple inheritance is allowed here)
    interfaces cannot implement/extend classes
    classes implement interfaces

    an interface with one and only one abstract method is known as a "functional interface"
    an interface that has NO declared methods iis known as a "marker interface"
     */


public interface InterfaceA {


    int value = 10;// implicitly public, static final
    void method1(); //implicitly abstract
    default void method2(){
        System.out.println("interface method with a default implementation");
    }
    // java pretty much has always allowed for interface to have static methods
    //shadowing vs overriding********
    static void method3(){
        System.out.println("i cannot be overridden, but i can be redeclared or shadowed");
    }
}
