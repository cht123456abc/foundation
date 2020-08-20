package cn.edu.scu.gof.bridge;

public interface Brand {

    void sale();
}

class Lenovo implements Brand {

    @Override
    public void sale() {
        System.out.println("卖lenovo");
    }
}

class Dell implements Brand {


    @Override
    public void sale() {
        System.out.println("卖dell");
    }
}
