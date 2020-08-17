package cn.edu.scu.gof.singleton;

public class StaticInnerClassSingleton {
	
	private StaticInnerClassSingleton() {
		
	}
	
	private static class SingletonHelper {
		private static final StaticInnerClassSingleton SINGLETON = new StaticInnerClassSingleton();// 静态内部类持有外部类的引用，并初始化
	}
	
	public static StaticInnerClassSingleton getInstance() {
		return SingletonHelper.SINGLETON;
	}
}
