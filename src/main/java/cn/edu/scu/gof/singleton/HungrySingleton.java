package cn.edu.scu.gof.singleton;

public class HungrySingleton {
	private static HungrySingleton singleton = new HungrySingleton();

	private HungrySingleton() {
	}

	public static HungrySingleton getInstance() {
		return singleton;
	}
}
