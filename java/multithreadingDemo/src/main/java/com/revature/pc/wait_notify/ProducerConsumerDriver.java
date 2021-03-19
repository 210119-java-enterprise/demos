package com.revature.pc.wait_notify;

public class ProducerConsumerDriver {
    
    public static void main(String[] args) throws InterruptedException {
        CustomBuffer buf = new CustomBuffer();
        final Object monitor = new Object();
        Producer producer = new Producer(buf, monitor);
        Consumer consumer = new Consumer(buf, monitor);

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

        // 0-10 (10 being highest, 0 being lowest, 5 being default) Just a suggestion to JVM
        producerThread.setPriority(8);
        consumerThread.setPriority(3);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Final buffer count: " + buf.getCount());
    }
}
