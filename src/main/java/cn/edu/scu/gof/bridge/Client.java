package cn.edu.scu.gof.bridge;

public class Client {
    public static void main(String[] args) {

        Computer computer = new Desktop(new Lenovo());
        computer.sale();


        Computer computer2 = new Laptop(new Dell());
        computer2.sale();
    }
}
