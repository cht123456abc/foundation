package cn.edu.scu.gof.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void action(double price) {

        System.out.println(strategy.getPrice(price));
    }
}
