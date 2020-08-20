package cn.edu.scu.gof.decorator;

public class Client {
    public static void main(String[] args) {

        Car car = new Car();

        // 添加飞行功能
        FlyCar flyCar = new FlyCar(car);

        // 添加水行功能
        SwimCar swimCar = new SwimCar(flyCar);
        swimCar.move();
    }
}
