package cn.edu.scu.gof.factorymethod;

public class BydFactory implements CarFactory{

	@Override
	public Car createCar() {
		return new Byd();
	}

}
