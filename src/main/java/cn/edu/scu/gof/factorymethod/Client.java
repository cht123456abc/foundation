package cn.edu.scu.gof.factorymethod;

public class Client {
	public static void main(String[] args) {
		Car a = new AudiFactory().createCar();
		Car b = new BydFactory().createCar();
		
		a.run();
		b.run();
	}
}
