package com.revature.classloading;

public class Bird {

    //non static initialization blocs
    // these run before constructor logic in the order they are declared
    {
        System.out.println("b1");
    }
    Bird() {
        System.out.println("b2");
    }

    // static initialization blocks
    // Run when the class declaration is loaded into JVM memory
    static {
        System.out.println("b3");
    }
}
