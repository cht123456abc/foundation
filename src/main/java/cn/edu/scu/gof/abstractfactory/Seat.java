package cn.edu.scu.gof.abstractfactory;

public abstract class Seat {
	public void comfortable() {}
}

class LuxurySeat extends Seat {
	public void comfortable() {
		System.out.println("舒适");
	}
}

class LowSeat extends Seat {
	public void comfortable() {
		System.out.println("不舒适");
	}
}
