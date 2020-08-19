package cn.edu.scu.gof.strategy.strategy_factory;

public interface Strategy{

    default void strategyMethodA() {
        throw new UnsupportedOperationException();
    }

    default void strategyMethodB() {
        throw new UnsupportedOperationException();
    }


}
