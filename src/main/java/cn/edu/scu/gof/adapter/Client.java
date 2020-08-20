package cn.edu.scu.gof.adapter;

public class Client {

    public static void main(String[] args) {
        // 请求者需要调用被适配者的功能
        Target target = new Adapter(new Adaptee());
        test(target);
    }

    public static void test(Target target) {
        target.handleRequest();
    }
}
