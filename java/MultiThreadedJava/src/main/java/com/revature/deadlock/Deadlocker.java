package com.revature.deadlock;

public class Deadlocker {

    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void methodA() {
        synchronized (lockA) {
            System.out.printf("[%s] is running inside of methodA()\n", Thread.currentThread().getName());
            methodB();
        }
    }

    public void methodB() {
        synchronized (lockB) {
            System.out.printf("[%s] is running inside of methodB()\n", Thread.currentThread().getName());
            methodC();
        }
    }

    public void methodC() {
        synchronized (lockA) {
            System.out.printf("[%s] is running inside of methodc()\n", Thread.currentThread().getName());
        }
    }
}
