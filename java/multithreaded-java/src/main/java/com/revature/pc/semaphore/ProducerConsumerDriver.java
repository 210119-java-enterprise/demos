package com.revature.pc.semaphore;

import java.util.concurrent.Semaphore;

public class ProducerConsumerDriver {

    public static void main(String[] args) throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1, true);
        CustomBuffer buffer = new CustomBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Runnable produceTask = () -> {
            for (int i = 1; i <= 2; i++) {
                System.out.println("Attempting to produce new value: " + i);
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                producer.produce(i);
                semaphore.release();
            }
            System.out.println("Done producing!");
            producer.setDoneProducing(true);
            semaphore.release();
        };

        Runnable consumeTask = () -> {
            while (!producer.isDoneProducing() || !buffer.isEmpty()) {
                System.out.println("Attempting to consume new value...");
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.consume();
                semaphore.release();
            }
            System.out.println("Done consuming!");
            semaphore.release();
        };

        Thread producerThread = new Thread(produceTask);
        producerThread.setName("producer-thread");

        Thread consumerThread = new Thread(consumeTask);
        consumerThread.setName("consumer-thread");

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Data in the buffer: " + buffer.getCount());
    }
}
