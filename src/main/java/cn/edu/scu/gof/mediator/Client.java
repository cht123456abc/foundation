package cn.edu.scu.gof.mediator;

public class Client {
    public static void main(String[] args) {

        Mediator m = new President();

        Development d = new Development(m);
        Financial d2 = new Financial(m);
        Market d3 = new Market(m);

        d3.selfAction();
        d3.outAction();

    }
}
