package cn.edu.scu.gof.proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        ProxyStar proxyStar = new ProxyStar(new RealStar());
        proxyStar.collectMoney();
        proxyStar.signContract();
        proxyStar.sing();
    }
}
