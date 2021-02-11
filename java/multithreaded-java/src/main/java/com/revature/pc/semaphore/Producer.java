package com.revature.pc.semaphore;

import com.revature.pc.wait_notify.CustomBuffer;

import java.util.concurrent.Semaphore;

public class Producer {

    private Semaphore semaphore;

    public Producer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void produce() {

            System.out.println("Acquiring.");
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
}
