package com.revature.race;

public class RaceConditionDriver {

    public static void main(String[] args) throws InterruptedException {

        IntWrapper intWrapper = new IntWrapper();

        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                intWrapper.incrementValue();
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++) {
                intWrapper.incrementValue();
            }
        };

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        /*
            Thread.start() vs Runnable.run()

                - Thread.start()
                    + Creates a new OS-level thread which will execute the logic
                      of the Runnable object associated with this Thread object.

                - Runnable.run()
                    + Does not actually create a new OS-level thread. It simply
                      executes the logic within the run() method on the thread
                      which invoked the method.
         */



        /*
            Thread.join()

                - This method of the Thread class can be invoked to place the calling
                  thread into the WAITING state. It will remain in this state until the
                  reference thread terminates.
         */
        t1.join();
        t2.join();

        System.out.println(intWrapper.getValue());

    }

}
