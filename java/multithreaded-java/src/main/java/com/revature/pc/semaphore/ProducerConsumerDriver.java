package com.revature.pc.semaphore;

public class ProducerConsumerDriver {

    public static void main(String[] args) throws InterruptedException {

        final Object monitor = new Object();
        CustomBuffer buffer = new CustomBuffer();

        ExampleSemaphore sem = new ExampleSemaphore();

        Producer producer = new Producer(buffer, sem);
        Consumer consumer = new Consumer(buffer, sem);

        Runnable consumeTask = () -> {
            for (int i = 0; i < 50; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming!");
        };

        Runnable produceTask = () -> {
           for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing!");
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        // 0 - 10 (0 being the lowest, 10 being the highest, and 5 being the default)
        //producerThread.setPriority(8);
        //consumerThread.setPriority(2);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Data in the buffer: " + buffer.getCount());
    }
}
