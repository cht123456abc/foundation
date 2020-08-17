package cn.edu.scu.gof.abstractfactory;

public class Client {
	public static void main(String[] args) {
		Car a = new LowCarFactory().createCar();
		
		a.getEngine().run();
		a.getSeat().comfortable();
	}
}
