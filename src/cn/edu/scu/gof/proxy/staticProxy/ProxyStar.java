package cn.edu.scu.gof.proxy.staticProxy;

public class ProxyStar implements Star {
    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney()");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract()");
    }
}
