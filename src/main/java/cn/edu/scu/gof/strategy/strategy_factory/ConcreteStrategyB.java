package cn.edu.scu.gof.strategy.strategy_factory;

public class ConcreteStrategyB implements Strategy{

    @Override
    public void strategyMethodA() {
        System.out.println("策略B->方法A");
    }

    @Override
    public void strategyMethodB() {
        System.out.println("策略B-》方法B");
    }
}
