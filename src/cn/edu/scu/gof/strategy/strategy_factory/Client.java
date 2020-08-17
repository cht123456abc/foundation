package cn.edu.scu.gof.strategy.strategy_factory;

public class Client {

    // 策略模式加工厂模式 代替大量的if-else
    public static void main(String[] args) {
        StrategyFactory.strategyMethod("A");
        StrategyFactory.strategyMethod("B");
    }
}
