package cn.edu.scu.gof.factorymethod;

public class AudiFactory implements CarFactory{

	@Override
	public Car createCar() {
		return new Audi();
	}

}
