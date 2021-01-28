package com.revature.classloading;

/*
Order of execution:
static members (includes static init blocks)
main method logic
<assume an object gets instantiated>
non-static init blocks run
constructor logic runs -- starting from parent
 */


public class Hawk extends Raptor {
    public static void main(String[] args) {
        System.out.println("init");
        new Hawk();
        System.out.println("hawk");
    }
}

