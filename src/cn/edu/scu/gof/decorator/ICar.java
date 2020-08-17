package cn.edu.scu.gof.decorator;

// 抽象接口
public interface ICar {

    void move();
}

//具体类型
class Car implements ICar {

    @Override
    public void move() {
        System.out.println("路上跑");
    }
}

//装饰器类型父类
class SuperCar implements ICar {
    protected ICar iCar;

    public SuperCar(ICar iCar) {
        this.iCar = iCar;
    }

    @Override
    public void move() {
        iCar.move();
    }
}

class FlyCar extends SuperCar {


    public FlyCar(ICar iCar) {
        super(iCar);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("天上跑");
    }
}

class SwimCar extends SuperCar {


    public SwimCar(ICar iCar) {
        super(iCar);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("水里跑");
    }
}