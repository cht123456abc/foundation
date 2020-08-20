package cn.edu.scu.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
    }
}
