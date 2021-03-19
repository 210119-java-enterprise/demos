package com.revature.executors;

import java.util.concurrent.*;

public class CallableDriver {

    public static void main(String[] args) {

        Runnable task_0 = () -> {
            throw new RuntimeException("Can you handle me?");
        };

        ExecutorService singleThreadPoolService = Executors.newSingleThreadExecutor();

        // You cannot handle exceptions raised within a Runnable task passed to Executor#execute!
//        try {
//            singleThreadPoolService.execute(task_0);
//        } catch (Exception e) {
//            System.out.println("handled!"); // does not execute, ever.
//        }

        singleThreadPoolService.shutdown();

        Callable<String> task_1 = () -> {
            throw new RuntimeException("Can you handle me?");
        };

        Callable<String> task_2 = () -> {
            Thread.sleep(200);
            return "task_2 is running inside of " + Thread.currentThread().getName();
        };


        ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(5);

        try {
            for (int i = 0; i < 10; i++) {
                Future<String> futureString = multiThreadExecutor.submit(task_2);

                // Provide a timeout to the get() call to avoid indefinitely waiting/blocking calls.
                System.out.println("Retrieved value: " + futureString.get(1000, TimeUnit.MILLISECONDS));
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            multiThreadExecutor.shutdown();
            multiThreadExecutor.execute(() -> System.out.println("this task will not be accepted after shutdown"));
        }

        /*
            Future interface

                Notable methods:
                    - V get() throws InterruptedException, ExecutionException;
                    - V get(long timeout, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException;
                    - boolean cancel(boolean b);
                    - boolean isCancelled();
                    - boolean isDone();

                A Future object is returned by the submit() call of the ExecutorService interface. The get() method
                of this object can be invoked to return the produced value (specified by the type parameter of the
                Callable task). This get() call is blocking until the value is produced, or until the Future is cancelled.

                If the task has completed, then the get() call will return the produced result immediately. If it is
                not ready, the get() call blocks the invoking thread until the result is ready.

                If an exception has been thrown within the Callable task, then it is wrapped up in an ExecutionException.
         */

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable beeper = () -> System.out.println("beep");
        //                                                              task    initDelay   period    TimeUnit
        ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 2,           5,       TimeUnit.SECONDS);
        scheduler.schedule(() -> { beeperHandle.cancel(true); }, 60, TimeUnit.SECONDS);

        /*
            Concurrent (thread-safe) Collection types:
                - java.util.concurrent
                    + ArrayBlockingQueue
                    + ConcurrentHashMap
                    + ConcurrentLinkedQueue
                    + ConcurrentLinkedDeque

                - java.util (traditional Collection framework classes)
                    + Vector (a type of List)
                    + Hashtable (a type of Map)
         */

    }
}
