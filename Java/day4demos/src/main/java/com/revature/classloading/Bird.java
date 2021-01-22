package com.revature.classloading;

public class Bird {

    // Non static initialization blocks.
    // RUN BEFORE CONSTRUCTOR LOGIC (IN THE ORDER THAT THEY ARE DECLARED)
    {
        System.out.println("b1");
    }
    Bird() {
        System.out.println("b2");
    }

    // Static initialization blocks
    // RUN WHEN THE CLASS DECLARATION IS LOADED INTO JVM MEMORY (BEFORE ANY OBJECT INSTANTIATION
    static {
        System.out.println("b3");
    }
}