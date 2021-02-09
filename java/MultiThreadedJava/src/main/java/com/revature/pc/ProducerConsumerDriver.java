package com.revature.pc;

public class ProducerConsumerDriver {

    public static void main(String[] args) throws InterruptedException {

        final Object monitor = new Object();

        CustomBuffer buffer = new CustomBuffer();

        Producer producer = new Producer(buffer, monitor);
        Consumer consumer = new Consumer(buffer, monitor);

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing");
        };

        Runnable consumeTask = () -> {
            for (int i = 0; i < 45; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming");
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Data in the buffer: " + buffer.getCount());
    }
}
