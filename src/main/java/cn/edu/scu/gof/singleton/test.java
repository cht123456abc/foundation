package cn.edu.scu.gof.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class test {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		long start = System.currentTimeMillis();
		pool.submit(() -> {
			for (int j = 0; j < 100000; j++) {
//				StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
//				DoubleLockSingleton singleton = DoubleLockSingleton.getInstance();
//				HungrySingleton singleton = HungrySingleton.getInstance();
//				LazySingleton singleton = LazySingleton.getInstance();
				EnumSingleton singleton = EnumSingleton.singleton;
				System.out.println(Thread.currentThread().getName() + ":" + singleton);
			}
		});
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
