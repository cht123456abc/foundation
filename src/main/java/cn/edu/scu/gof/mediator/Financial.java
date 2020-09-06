package cn.edu.scu.gof.mediator;

public class Financial implements Department {
    private Mediator mediator;

    public Financial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("financial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("金融部数钱");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作");
    }
}
