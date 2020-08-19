package cn.edu.scu.gof.observer;

public class Client {
    public static void main(String[] args) {
        // 创建多个观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        // 在目标对象中注册观察者
        SubjectA subject = new SubjectA();
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);

        // 打印原来的所有观察者的状态
        System.out.println(obs1.getMystate());
        System.out.println(obs2.getMystate());
        System.out.println(obs3.getMystate());

        // 更新目标对象
        subject.setState(100);

        // 打印现在的观察者的状态
        System.out.println(obs1.getMystate());
        System.out.println(obs2.getMystate());
        System.out.println(obs3.getMystate());
    }

}
