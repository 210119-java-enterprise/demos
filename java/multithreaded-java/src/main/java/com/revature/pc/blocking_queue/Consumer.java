package com.revature.pc.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer {

    private ArrayBlockingQueue<Integer> queue;
    private CustomBuffer buffer;

    public Consumer(CustomBuffer buffer, ArrayBlockingQueue<Integer> queue) {
        this.buffer = buffer;
        this.queue = queue;
    }

    public void consume() {
        try {
            queue.take();
            buffer.getBufferArray()[buffer.getCount() - 1] = 0;
            buffer.decrementCount();
            System.out.println("Consumed new value.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
