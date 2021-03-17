package cn.edu.scu.gof.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RealStarHandler implements InvocationHandler {

    private Star realStar;// 目标类

    public RealStarHandler(Star realStar) {
        this.realStar = realStar;
    }

    /**
     * 代理实现
     * @param proxy 反射生成的目标类的代理类
     * @param method 目标类调用的方法
     * @param args 目标类调用方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(realStar.getClass().getName());// 目标类
        System.out.println(proxy.getClass().getName());// 代理类

        if (method.getName().equals("sing")) {
            System.out.println("代理人开始代理签合同");
            method.invoke(realStar, args);
            System.out.println("代理人开始收钱");
        }
        return null;
    }
}
