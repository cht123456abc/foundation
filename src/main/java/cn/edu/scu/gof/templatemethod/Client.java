package cn.edu.scu.gof.templatemethod;

public class Client {

    public static void main(String[] args) {
        new BankTemplateMethod().process();
    }

}


class BankTemplateMethod extends TemplateMethod
{

    @Override
    public void secondStep() {
        System.out.println("第二步:");
        System.out.println("办理业务");
    }
}