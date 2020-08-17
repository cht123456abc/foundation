package cn.edu.scu.gof.abstractfactory;

public interface CarFactory {

	Engine createEngine();
	Seat createSeat();
	Car createCar();
}
