package com.revature.deadlock;

public class Deadlocker {
    
    private final Object monitorA = new Object();
    private final Object monitorB = new Object();

    public void methodA() {
        synchronized (monitorA) {
            System.out.printf("[%s] is running inside methodA()\n", Thread.currentThread().getName());
            methodB();
        }
    }

    public void methodB() {
        synchronized (monitorB) {
            System.out.printf("[%s] is running inside methodB()\n", Thread.currentThread().getName());
            methodC();
        }
    }

    /**
     * Will create possibility for a deadlock unless lock
     * is changed. Could be changed to monitorB (because methodC
     * is only called by methodB), or to a third monitor object.
     */
    public void methodC() {
        synchronized (monitorA) {
            System.out.printf("[%s] is running inside methodC()\n", Thread.currentThread().getName());
        }
    }

}
