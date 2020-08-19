package cn.edu.scu.gof.abstractfactory;

public class LowCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new LowEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new LowSeat();
	}

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setEngine(new LowEngine());
		car.setSeat(new LowSeat());
		return car;
	}

}
