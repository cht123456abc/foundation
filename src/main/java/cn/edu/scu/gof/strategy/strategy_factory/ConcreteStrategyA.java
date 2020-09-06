package cn.edu.scu.gof.strategy.strategy_factory;

public class ConcreteStrategyA implements Strategy{
    @Override
    public void strategyMethodA() {
        System.out.println("策略A->方法A");
    }

    @Override
    public void strategyMethodB() {
        System.out.println("策略A->方法B");
    }
}
