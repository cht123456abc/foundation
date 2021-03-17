package cn.edu.scu.gof.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        // 实现InvocationHandler接口的Handler类
        RealStarHandler handler = new RealStarHandler(realStar);
        // 目标类RealStar一定要实现接口（Star）
        // 生成的代理类则一定是实现该接口的类
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        // 开始代理
        proxy.sing();
    }
}
