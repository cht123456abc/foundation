package cn.edu.scu.gof.builder;

public class SxtAirShipBuilder implements AirShipBuilder{


    @Override
    public Engine buildEngine() {
        System.out.println("创建sxt发动机");
        return new Engine("sxt发动机");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("创建sxt逃逸塔");
        return new EscapeTower("sxt逃逸塔");
    }

    @Override
    public OrbitalModule buildOrbitalModule() {
        System.out.println("创建sxt轨道舱");
        return new OrbitalModule("sxt轨道舱");
    }
}
