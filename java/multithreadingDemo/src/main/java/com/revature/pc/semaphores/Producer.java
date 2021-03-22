package com.revature.pc.semaphores;

import java.util.concurrent.Semaphore;

public class Producer {

    private CustomBuffer buf;
    private final Semaphore sem;

    public Producer(CustomBuffer buf, Semaphore sem) {
        this.buf = buf;
        this.sem = sem;
    }

    public void produce() {
        try {
            sem.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        while (buf.isFull()) {
            System.out.println("Buffer is full, pausing producer thread.");
            sem.release();
            try {
                Thread.sleep(10);
                sem.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // if (buf.isFull()) {
        //     sem.release();
        //     while(buf.isFull()) {

        //     }
        //     try {
        //         Thread.sleep(100);
        //         sem.acquire();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // } 

        System.out.println("size of buf: " + buf.getCount());
        // if (!buf.isFull()) {
        buf.getBufferArray()[buf.getCount()] = 1;
        buf.incrementCount();
        // } else {
        //     sem.release();
        // }

        System.out.println("Produced new value. Notifying semaphore");
        sem.release();

    }
}
