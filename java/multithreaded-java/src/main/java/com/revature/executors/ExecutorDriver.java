package com.revature.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDriver {

    public static void main(String[] args) {

        // Creating a thread using the Runnable pattern
        Runnable task_0 = () -> System.out.println("Hello world!");

        // create on-demand thread (very resource-intensive!)
        Thread thread = new Thread(task_0);
        thread.start();

        /*
            1. A thread is created on demand...by a developer.
            2. Once the task is complete, the thread is terminated/dies.
            3. Threads are expensive resources, and we should be able to reuse them!
            4. Runnable has no return value, and cannot raise exceptions.
         */

        /*
            Executor Pattern

                - aims to improve the use of thread resources
                    + by creating pools of ready-to-use threads
                    + Runnable tasks are given to existing threads in some pool
                    + threads remain in the pool even after the Runnable logic is complete

                - two required patterns:
                    + create a pool of threads
                    + pass a task to a thread within the pool


                Executor pattern:
                    executor.execute(task);

                Runnable pattern:
                    new Thread(task);
         */

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        Executor multipleThreadExecutor = Executors.newFixedThreadPool(10);

        Runnable task_1 = () -> System.out.println("task_1 is running in " + Thread.currentThread().getName());
        Runnable task_2 = () -> System.out.println("task_2 is running in " + Thread.currentThread().getName());

        // Tasks are executed in the order they are submitted to the ExecutorService
        singleThreadExecutor.execute(task_1);
        singleThreadExecutor.execute(task_2);
        System.out.println("main logic");

        // This is necessary, otherwise the JVM continues to run indefinitely because
        // it will not end until all non-daemon threads are terminated.
        singleThreadExecutor.shutdown();
    }
}
