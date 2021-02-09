package com.revature.pc;

public class Producer {

    private CustomBuffer buf;
    private final Object monitor;

    public Producer(CustomBuffer buf, Object monitor) {
        this.buf = buf;
        this.monitor = monitor;
    }

    public void produce() {
        synchronized (monitor) {
            if (buf.isFull()) {
                System.out.println("Buffer is full, pausing producer thread.");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    
            buf.getBufferArray()[buf.getCount()] = 1;
            buf.incrementCount();
    
            System.out.println("Produced new value. Notifying monitor");
            monitor.notify();
        }

    }
}
