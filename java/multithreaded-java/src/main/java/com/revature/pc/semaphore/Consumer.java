package com.revature.pc.semaphore;

public class Consumer {

    private final ExampleSemaphore sem;
    private CustomBuffer buffer;

    public Consumer(CustomBuffer buffer, ExampleSemaphore sem) {
        this.buffer = buffer;
        this.sem = sem;
    }

    public void consume() {
            try{
                sem.get();
                buffer.getBufferArray()[buffer.getCount() - 1] = 0;
                buffer.decrementCount();
                System.out.println("Consumed new value.");
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
