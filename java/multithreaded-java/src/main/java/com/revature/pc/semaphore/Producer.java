package com.revature.pc.semaphore;

public class Producer {

    private CustomBuffer buffer;
    private volatile boolean doneProducing = false;

    public Producer(CustomBuffer intBuffer) {
        this.buffer = intBuffer;
    }

    public void produce(int value) {
        buffer.getBufferArray()[buffer.getCount()] = value;
        buffer.incrementCount();
        System.out.println("\tProduced new value: " + value);
        System.out.println("\tArray contents: " + buffer.printBufferContents());
    }

    public void setDoneProducing(boolean isDone) {
        doneProducing = isDone;
    }

    public boolean isDoneProducing() {
        return doneProducing;
    }

}
