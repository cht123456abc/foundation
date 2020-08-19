package cn.edu.scu.gof.state;

public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已预定！");
    }
}
