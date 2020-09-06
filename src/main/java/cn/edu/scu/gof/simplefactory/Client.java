package cn.edu.scu.gof.simplefactory;

public class Client {

	public static void main(String[] args) {
		Car car1 = Factory.createCar("奥迪");
		Car car2 = Factory.createCar("比亚迪");
		
		car1.run();
		car2.run();
	}
}
