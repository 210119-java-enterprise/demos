package com.revature.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDriver {
    public static void main(String[] args) {
        Runnable task0 = () -> {
            throw new RuntimeException("Can you handle me?");
        };
        ExecutorService singleThreadPoolService = Executors.newSingleThreadExecutor();
        try {
            singleThreadPoolService.execute(task0);
        } catch (Exception e) {
            // Never runs
            System.out.println("Caught exception");
        } finally {
            singleThreadPoolService.shutdown();
        }

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Callable<String> task1 = () -> {
            throw new RuntimeException("Can you handle me?");
        };
        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "task2 is running in " + Thread.currentThread().getName();
        };
        ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(3);

        Future<String> futureString;
        try {
            // futureString = multiThreadExecutor.submit(task1);
            // futureString.get();
            for (int i = 0; i < 10; i++) {
                futureString = multiThreadExecutor.submit(task2);
                System.out.println("retrieved value: " + futureString.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("------------------");
            e.printStackTrace();
            System.out.println("------------------");
        } finally {
            multiThreadExecutor.shutdown();
        }
    }
}
