package cn.edu.scu.gof.proxy.dynamicProxy;

public class RealStar implements Star {

    public void sing() {
        System.out.println("RealStar.sing()");
    }

    @Override
    public void collectMoney() {

    }

    @Override
    public void signContract() {

    }
}
