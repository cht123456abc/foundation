package cn.edu.scu.gof.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RealStarHandler implements InvocationHandler {

    private Star realStar;

    public RealStarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("sing")) {
            method.invoke(realStar, args);
        }

        return null;
    }
}
