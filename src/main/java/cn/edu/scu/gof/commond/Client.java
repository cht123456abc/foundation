package cn.edu.scu.gof.commond;

public class Client {

    public static void main(String[] args) {

        Invoke invoke = new Invoke(new ConcreteCommand(new Receiver()));

        invoke.call();
    }
}
