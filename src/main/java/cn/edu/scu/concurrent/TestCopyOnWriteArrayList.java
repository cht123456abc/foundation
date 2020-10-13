package cn.edu.scu.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new CopyOnWriteArrayList();
        List<Integer> list3 = Collections.synchronizedList(list1);

        // 测试并发时分别对ArrayList   与 CopyOnWriteArrayList的影响
        Thread[] threads = new Thread[50];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    list3.add(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(list3.size());
            });
        }

        // 开启所有线程
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        // 让所有线程参与主线程，即让主线程等待所有线程执行完。
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("main线程：" + list3.size());

    }
}
