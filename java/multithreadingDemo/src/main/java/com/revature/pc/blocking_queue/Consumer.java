package com.revature.pc.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Consumer {

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void consume() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Consumed new value.");
    }
    
}
