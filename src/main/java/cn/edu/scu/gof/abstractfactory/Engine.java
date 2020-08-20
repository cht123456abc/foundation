package cn.edu.scu.gof.abstractfactory;

public abstract class Engine{
	public void run() {}
}

class LuxuryEngine extends Engine {
	public void run() {
		System.out.println("跑得快");
	}
}

class LowEngine extends Engine {
	public void run() {
		System.out.println("跑得慢");
	}
}
