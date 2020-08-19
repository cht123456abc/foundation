package cn.edu.scu.gof.builder;

public class SxtAirShipDirector implements AirShipDirector {

    private AirShipBuilder builder;

    public SxtAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine e = builder.buildEngine();
        EscapeTower et = builder.buildEscapeTower();
        OrbitalModule o = builder.buildOrbitalModule();

        AirShip ship = new AirShip();
        ship.setEngine(e);
        ship.setEscapeTower(et);
        ship.setOrbitalModule(o);

        return ship;
    }
}
