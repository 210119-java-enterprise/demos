package com.revature.pc.blocking_queue;

import java.util.concurrent.SynchronousQueue;

public class Producer {

    private SynchronousQueue myQueue = new SynchronousQueue();

    public Producer(SynchronousQueue myQueue) {
        this.myQueue = myQueue;
    }

    public void produce() {


        try{
            myQueue.put("Food");
            System.out.println("Produced");
        } catch (InterruptedException e){
            System.out.println("Waiting");
        }

    }
}
