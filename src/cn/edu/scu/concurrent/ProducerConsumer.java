package cn.edu.scu.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);// 固定长度的队列

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        }
    }

    private static class Consumer extends Thread {

        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        }
    }

    public static void main(String[] args) {
        Producer[] producers = new Producer[5];
        Consumer[] consumers = new Consumer[5];
        for (int i = 0; i < 5; i++) {
            producers[i] = new Producer();
            consumers[i] = new Consumer();
        }
        for (int i = 0; i < 5; i++) {
            producers[i].start();
            consumers[i].start();
        }

    }
}