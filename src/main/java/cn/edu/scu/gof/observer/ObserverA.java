package cn.edu.scu.gof.observer;

public class ObserverA implements Observer {

    private int mystate = 0;

    public int getMystate() {
        return mystate;
    }

    @Override
    public void update(Subject subject) {
        mystate = ((SubjectA)subject).getState();
    }
}
