package cn.edu.scu.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();


    private void getA() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "拿到A锁");
        try {
            b.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            a.signal();
            lock.unlock();
            System.out.println("getA方法结束。");
        }

    }

    private void getB() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "拿到B锁");
        try {
            a.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            b.signal();
            lock.unlock();
            System.out.println("getB方法结束。");
        }
    }


    public static void main(String[] args) {
        DeadLock T = new DeadLock();

        new Thread(() -> {
            T.getA();
        }).start();

        new Thread(() -> {
            T.getB();
        }).start();
    }
}
