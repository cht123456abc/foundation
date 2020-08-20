package cn.edu.scu.gof.mediator;

public class Market implements Department {
    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("市场部销售");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作");
        System.out.println("市场部需要资金支持 ");

        mediator.command("financial");
    }
}
