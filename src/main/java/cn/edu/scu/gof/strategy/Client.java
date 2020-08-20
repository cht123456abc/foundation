package cn.edu.scu.gof.strategy;

public class Client {
    public static void main(String[] args) {

        Context ctx = new Context(new OldCustomerLowPriceStrategy());

        ctx.action(998);

    }
}
