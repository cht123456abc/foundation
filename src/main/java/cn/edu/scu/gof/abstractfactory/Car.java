package cn.edu.scu.gof.abstractfactory;

public class Car {
	Engine engine;
	Seat seat;
	public Engine getEngine() {
		return engine;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
