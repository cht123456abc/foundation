package cn.edu.scu.concurrent;

import java.util.concurrent.Semaphore;

public class PrintOddEven {

    static int n;

    public static void main(String[] args) {

        n = 10;
        Semaphore o = new Semaphore(1);
        Semaphore e = new Semaphore(0);
        PrintOdd printOdd = new PrintOdd();
        printOdd.set(n,o,e);
        PrintEven printEven = new PrintEven();
        printEven.set(n, o, e);
        Thread thread1 = new Thread(printOdd);
        thread1.start();
        Thread thread2 = new Thread(printEven);
        thread2.start();

    }


}

class PrintOdd implements Runnable {

    private int n;
    private Semaphore semaphore_o;
    private Semaphore semaphore_e;


    public void set(int n,Semaphore semaphore_o,Semaphore semaphore_e){
        this.n = n;
        this.semaphore_o = semaphore_o;
        this.semaphore_e = semaphore_e;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i += 2) {
            try {
                semaphore_o.acquire();
                System.out.println(i);
                semaphore_e.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintEven implements Runnable {

    private int n;
    private Semaphore semaphore_o;
    private Semaphore semaphore_e;


    public void set(int n,Semaphore semaphore_o,Semaphore semaphore_e){
        this.n = n;
        this.semaphore_o = semaphore_o;
        this.semaphore_e = semaphore_e;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; i += 2) {
            try {
                semaphore_e.acquire();
                System.out.println(i);
                semaphore_o.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}