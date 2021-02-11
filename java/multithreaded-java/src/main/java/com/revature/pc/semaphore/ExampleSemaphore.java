package com.revature.pc.semaphore;

import java.util.concurrent.Semaphore;

public class ExampleSemaphore {

    private Semaphore conSem = new Semaphore(0);
    private Semaphore prodSem = new Semaphore(5);

    public ExampleSemaphore() {

    }

    void get() {
        try {
            conSem.acquire();
            System.out.println("\tConsumerSemaphore Acquired ");
        }catch(Exception e){
            System.out.println("InterruptedException caught");
        }
        //Do something
        prodSem.release();

    }

    void put() {
        try {
            prodSem.acquire();
            System.out.println("\tProducerSemaphore Acquired ");
        }catch(Exception e){
            System.out.println("InterruptedException caught");
        }
        //Do something
        conSem.release();
    }

    int availableSlots() {
        return conSem.availablePermits();
    }

}