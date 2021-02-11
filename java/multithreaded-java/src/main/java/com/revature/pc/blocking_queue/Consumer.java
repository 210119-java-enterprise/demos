package com.revature.pc.blocking_queue;

import java.util.concurrent.SynchronousQueue;

public class Consumer {

    private SynchronousQueue myQueue = new SynchronousQueue();

    public Consumer(SynchronousQueue myQueue) {
        this.myQueue = myQueue;
    }

    public void consume() {


        try{
            myQueue.take();
            System.out.println("Consumed");
        } catch (InterruptedException e){
            System.out.println("Waiting");
        }

    }
}
