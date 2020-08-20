package cn.edu.scu.gof.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    // 观察者队伍容器
    protected List<Observer> list = new ArrayList<>();

    // 注册观察者
    public void registerObserver(Observer obs) {
        list.add(obs);
    }

    // 移除观察者
    public void removeObserver(Observer obs) {
        list.remove(obs);
    }

    // 通知所有观察者
    protected void notifyAllObserver() {
        for (Observer obs : list) {
            obs.update(this);
        }
    }

}
