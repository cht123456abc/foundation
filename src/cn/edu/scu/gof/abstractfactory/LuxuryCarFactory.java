package cn.edu.scu.gof.abstractfactory;

public class LuxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new LuxuryEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new LuxurySeat();
	}

	@Override
	public Car createCar() {
		Car car = new Car();
		car.setEngine(new LuxuryEngine());
		car.setSeat(new LuxurySeat());
		return car;
	}

}
