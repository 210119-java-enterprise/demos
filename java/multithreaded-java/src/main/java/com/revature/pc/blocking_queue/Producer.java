package com.revature.pc.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer {

    private ArrayBlockingQueue <Integer>queue;
    private CustomBuffer buffer;

    public Producer(CustomBuffer buffer, ArrayBlockingQueue<Integer> queue) {
        this.buffer = buffer;
        this.queue = queue;
    }

    public void produce() {
        try {
            queue.put(1);
            buffer.getBufferArray()[buffer.getCount()] = 1;
            buffer.incrementCount();
            System.out.println("Produced new value.");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
