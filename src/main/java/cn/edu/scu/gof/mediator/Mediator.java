package cn.edu.scu.gof.mediator;

public interface Mediator {

    void register(String s, Department department);

    void command(String s);

}
