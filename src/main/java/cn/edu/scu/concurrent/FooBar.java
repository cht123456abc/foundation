package cn.edu.scu.concurrent;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1115. 交替打印FooBar
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 */
public class FooBar {

//    // 方法二 volatile + 自旋
//    private volatile boolean mutex;
//
//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//
//            while (mutex) {
//                Thread.yield();
//            }
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            mutex = true;
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//
//            while (!mutex) {
//                Thread.yield();
//            }
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            mutex = false;
//        }
//    }



//     方法一 synchronized + 自旋
    private int n;
    private final Object lock = new Object();
    private boolean mutex = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                while(mutex){
                    lock.wait();
                }
                printFoo.run();
                mutex = true;
                lock.notify();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(lock) {
                while(!mutex){
                    lock.wait();
                }
                printBar.run();
                mutex = false;
                lock.notify();
            }
        }
    }
}
