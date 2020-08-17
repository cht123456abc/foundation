package cn.edu.scu.gof.templatemethod;

public abstract class TemplateMethod {

    public void firstStep() {
        System.out.println("第一步:查询余额");
    }

    // 留给子类实现的方法
    public abstract void secondStep();

    public void thirdStep() {
        System.out.println("第三步：取钱");
    }

    // 将过程，流程模版化，将具体步骤实现留给子类
    public final void process() {
        firstStep();
        secondStep();
        thirdStep();
    }

}
