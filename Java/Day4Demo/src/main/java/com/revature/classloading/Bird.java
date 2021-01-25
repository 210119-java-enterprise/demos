package com.revature.classloading;

public class Bird {
    // non static initialization blocks run before constructor logic
    {
        System.out.println("b1");
    }
    Bird() {
        System.out.println("b2");
    }
    // static initialization blocks run when class declaration is loaded in jvm memory (before any object instantiation)
    static {
        System.out.println("b3");
    }
}
