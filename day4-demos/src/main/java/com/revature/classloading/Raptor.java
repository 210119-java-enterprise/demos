package com.revature.classloading;

import com.revature.classloading.Bird;

public class Raptor extends Bird {
    static {
    System.out.println("r1");
}    Raptor() {
    System.out.println("r2");
}    {
    System.out.println("r5");
}    {
    System.out.println("r3");
}    static {
    System.out.println("r4");
}}
