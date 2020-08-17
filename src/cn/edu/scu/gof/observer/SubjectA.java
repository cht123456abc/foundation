package cn.edu.scu.gof.observer;

public class SubjectA extends Subject {

    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;

        this.notifyAllObserver();
    }
}
