package cn.edu.scu.concurrent;

import java.util.concurrent.*;

public class TestExecutorService {

    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(() -> {
            System.out.println("1");
        });

        FutureTask futureTask = new FutureTask(() -> 1);
        try {
            futureTask.run();
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
