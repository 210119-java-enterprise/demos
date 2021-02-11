package com.revature.pc.semaphore;

import java.util.concurrent.Semaphore;

public class Producer {

    private final ExampleSemaphore sem;
    private CustomBuffer buffer;

    public Producer(CustomBuffer buffer, ExampleSemaphore sem) {
        this.buffer = buffer;
        this.sem = sem;
    }

    public void produce() {
            try {
                sem.put();
                buffer.getBufferArray()[buffer.getCount()] = 1;
                buffer.incrementCount();
                System.out.println("Produced new value.");
            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
