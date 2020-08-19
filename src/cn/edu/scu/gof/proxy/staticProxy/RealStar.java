package cn.edu.scu.gof.proxy.staticProxy;

public class RealStar implements Star{

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
