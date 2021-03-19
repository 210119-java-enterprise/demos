package com.revature.pc.blocking_queue;

import java.util.concurrent.atomic.AtomicBoolean;

public class Producer {

    private final Object monitor = new Object();
    private CustomBuffer buffer;
    private volatile AtomicBoolean doneProducing = new AtomicBoolean(false);

    public Producer(CustomBuffer buffer) {
        this.buffer = buffer;
    }

    public void produce(int value) {

        try {
            buffer.getBufferQueue().put(value);
            System.out.println("\tProduced new value: " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setDoneProducing(boolean isDone) {
        synchronized (monitor) {
            doneProducing.set(isDone);
        }
    }

    public AtomicBoolean isDoneProducing() {
        synchronized (monitor) {
            return doneProducing;
        }
    }

}
