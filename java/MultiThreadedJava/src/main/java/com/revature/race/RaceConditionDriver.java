package com.revature.race;

public class RaceConditionDriver {

    public int counter() throws InterruptedException {
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
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        return intWrapper.getValue();
    }

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
        Thread t2 = new Thread(r2);

        /* run vs start

                -Thread.start()
                   + Creates a new OS-level thread which will execute the logic of
                        the Runnable object associated with this Thread object

                - Runnable.run()
                    + Does not actually create a new OS-level thread. It simply
                        executes the logic within the run() method on the thread
                        which invoked the method.
        */
        t1.start();
        t2.start();

        /*
            Thread.join()

                    - This method of the Thread class can be invoked to place the calling thread into the WAITING state.
                        It will remain in this state until the reference thread terminates
         */
        t1.join();
        t2.join();

        //System.out.println(intWrapper.getValue());

        System.out.println("+--------------------------");

        double aveTimesOff = 0.0;
        double aveAmtOff = 0.0;

        int numRuns = 100000;

        RaceConditionDriver rc = new RaceConditionDriver();

        for (int i = 1; i <= numRuns; i++) {
            int temp = rc.counter();
            aveAmtOff += temp;

            if (temp != 2000) {
                aveTimesOff++;
            }

        }

        System.out.println("The method is on average wrong by "+(2000 - (aveAmtOff/numRuns)));
        System.out.println("The method is wrong "+((aveTimesOff/numRuns)*100)+"% of the time.");

    }
}
