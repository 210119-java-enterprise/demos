package com.revature.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDriver {

    public static void main(String[] args) {

        // Runnable pattern
        Runnable task0 = () -> System.out.println("Hello there");
        Thread t = new Thread(task0);
        t.start();

        /**
         *  1. A thread is created on demand by a developer
         *      - Could lead to more threads than necessary being created
         *  2. Cannot reuse threads once task is complete (thread terminated)
         *  3. Threads are expensive resources and we should be able to reuse them
         */

        // Builds pool with one thread in it
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // Builds pool with n threads in it
        // ExecutorService multipleThreadExecutor = Executors.newFixedThreadPool(10);

        Runnable task1 = () -> System.out.println("General Kenobi!\nI am running in " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("This will make a fine addition to my collection\nI am running in " + Thread.currentThread().getName());
        // Executors will give tasks to thread(s) in order given
        singleThreadExecutor.execute(task1);
        singleThreadExecutor.execute(task2);
        // multipleThreadExecutor.execute(task1);
        // multipleThreadExecutor.execute(task2);
        
        // Shutdown Executors so application can finish
        singleThreadExecutor.shutdown();
        // multipleThreadExecutor.shutdown();


    }
}