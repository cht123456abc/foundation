package cn.edu.scu.gof.singleton;

public class DoubleLockSingleton {
	private volatile static DoubleLockSingleton singleton;// volatile 禁止JVM的指令重排

	private DoubleLockSingleton() {
	}

	public static DoubleLockSingleton getInstance() {
		if (singleton == null) {
			synchronized (DoubleLockSingleton.class) {
				if (singleton == null) {
					singleton = new DoubleLockSingleton();
				}
			}
		}
		return singleton;
	}
}
