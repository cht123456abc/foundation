package cn.edu.scu.gof.adapter;

/**
 * 适配器
 */
public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
