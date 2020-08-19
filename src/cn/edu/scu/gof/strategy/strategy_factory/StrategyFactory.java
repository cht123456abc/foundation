package cn.edu.scu.gof.strategy.strategy_factory;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    private static final Map<String,Strategy> strategyMap = new HashMap<>();

    // 静态代码块初始化所有的策略，或者采用反射的方式去动态加载类
    static {
        strategyMap.put("A", new ConcreteStrategyA());
        strategyMap.put("B", new ConcreteStrategyB());
    }

    public static void putStrategy(String name, Strategy strategy) {

        strategyMap.put(name, strategy);
    }

    public static Strategy getStragety(String name){
        return strategyMap.get(name);
    }


    public static void strategyMethod(String name) {
        strategyMap.get(name).strategyMethodA();
        strategyMap.get(name).strategyMethodB();
    }

}
