package com.revature.race;

public class RaceConditionDriver {
    
    /**
     * Simple implementation of a race condition if 
     * IntWrapper.incrementValue() is not synchronized
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        IntWrapper intWrapper = new IntWrapper();

        Runnable r1 = () -> {
            for (int i = 0; i < 10000; i++) {
                intWrapper.incrementValue();
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 10000; i++) {
                intWrapper.incrementValue();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        // Don't use .run() method, doesn't create a new thread
        t1.start();
        t2.start();

        // Main thread waits until t1 and t2 are done
        t1.join();
        t2.join();

        System.out.println(intWrapper.getValue());
    }
}
