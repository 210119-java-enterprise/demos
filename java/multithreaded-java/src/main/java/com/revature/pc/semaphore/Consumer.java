package com.revature.pc.semaphore;

import com.revature.pc.wait_notify.CustomBuffer;

import java.util.concurrent.Semaphore;

public class Consumer {

    private Semaphore semaphore;

    public Consumer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void consume() {

        System.out.println("Releasing.");
        try {
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
