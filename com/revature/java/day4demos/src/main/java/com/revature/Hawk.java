package com.revature;

public class Hawk extends Raptor {
    public static void main(String[] args) {
        System.out.println("init");
        new Hawk();
        System.out.println("hawk");

        // prints b3, r1, r4, init, b1, b2, r5, r3, r2, hawk
    }
}
