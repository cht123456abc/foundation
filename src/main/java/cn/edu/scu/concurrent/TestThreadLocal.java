package cn.edu.scu.concurrent;

public class TestThreadLocal {



    // 创建一个 ThreadLocal 变量，用于存储每个线程独立的值
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);
    private static ThreadLocal<Integer> threadLocalValue2 = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建多个线程，每个线程都对 ThreadLocal 中的值进行操作
        Thread thread1 = new Thread(() -> {
            threadLocalValue.set(1); // 设置线程1的值
            threadLocalValue2.set(3); // 设置线程1的值
            System.out.println("Thread 1 Value: " + threadLocalValue.get()); // 获取并打印线程1的值
            System.out.println("Thread 1 Value: " + threadLocalValue2.get()); // 获取并打印线程1的值
        });

        Thread thread2 = new Thread(() -> {
            threadLocalValue.set(2); // 设置线程2的值
            threadLocalValue2.set(3); // 设置线程2的值

            System.out.println("Thread 2 Value: " + threadLocalValue.get()); // 获取并打印线程2的值
            System.out.println("Thread 2 Value: " + threadLocalValue2.get()); // 获取并打印线程2的值
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // 等待线程1完成
            thread2.join(); // 等待线程2完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程查看 ThreadLocal 中的值
        System.out.println("Main thread Value: " + threadLocalValue.get()); // 主线程的值默认为0

        System.out.println(threadLocalValue.equals(threadLocalValue2));
    }
}
