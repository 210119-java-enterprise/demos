package com.revature.pc;

public class Consumer {

    private final Object monitor;
    private CustomBuffer buffer;

    public Consumer(CustomBuffer buffer, Object monitor) {
        this.buffer = buffer;
        this.monitor = monitor;
    }

    public void consume() {

        synchronized (monitor) {
            if (buffer.isEmpty()) {
                System.out.println("Buffer is empty, pausing consumer thread.");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            buffer.getBuffer()[buffer.getCount() - 1] = 0;
            buffer.decrementCount();

            System.out.println("Consumed new value. Notifying monitor.");
            monitor.notify();
        }
    }
}
