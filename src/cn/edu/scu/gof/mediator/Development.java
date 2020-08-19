package cn.edu.scu.gof.mediator;

public class Development implements Department {
    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发部研发项目");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作");
    }
}
