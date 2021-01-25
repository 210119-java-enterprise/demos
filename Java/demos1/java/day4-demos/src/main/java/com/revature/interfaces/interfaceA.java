package com.revature.interfaces;

// interfaces do not have constructors, are abstract data types, methods with no body are abstract,
//      variables are implicitly public static final
//      since java 8 you can have default methods that can be overriden

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public interface interfaceA {

    int value = 5; // implicitly public static final
    void method1(); //implicitly abstract

    //added in java8 for backwards compatability
    default void method2() {
        System.out.println("interface method with default implementaiton");
    }
}
