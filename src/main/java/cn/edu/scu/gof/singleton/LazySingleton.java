package cn.edu.scu.gof.singleton;

public class LazySingleton {
	private static LazySingleton singleton;

	// 私有化构造器
	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (singleton == null) {
			singleton = new LazySingleton();
		}
		return singleton;
	}
}
