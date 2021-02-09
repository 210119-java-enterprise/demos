package com.revature.pc;

public class Consumer {

    private CustomBuffer buf;
    private final Object monitor;

    public Consumer(CustomBuffer buf, Object monitor) {
        this.buf = buf;
        this.monitor = monitor;
    }

    public void consume() {
        synchronized (monitor) {
            if (buf.isEmpty()) {
                System.out.println("Buffer is empty, pausing consumer thread.");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            buf.getBufferArray()[buf.getCount() - 1] = 0;
            buf.decrementCount();

            System.out.println("Consumed new value. Notifying monitor");
            monitor.notify();
        }
    }
    
}
