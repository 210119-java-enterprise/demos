package com.revature.pc.blocking_queue;

public class ProducerConsumerDriver {

    public static void main(String[] args) throws InterruptedException {

        CustomBuffer buffer = new CustomBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Runnable produceTask = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Attempting to produce new value: " + i);
                producer.produce(i);
                System.out.println("\tArray contents: " + buffer.printBufferContents());
            }
            System.out.println("Done producing!");
            producer.setDoneProducing(true);
        };

        Runnable consumeTask = () -> {
            while (!producer.isDoneProducing().get()) {
                System.out.println("Attempting to consume new value...");
                consumer.consume();
            }
            System.out.println("Done consuming!");
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Data in the buffer: " + buffer.getBufferQueue().size());
    }
}
