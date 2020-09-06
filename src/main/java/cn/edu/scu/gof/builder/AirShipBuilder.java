package cn.edu.scu.gof.builder;

public interface AirShipBuilder {
    Engine buildEngine();
    EscapeTower buildEscapeTower();
    OrbitalModule buildOrbitalModule();
}
