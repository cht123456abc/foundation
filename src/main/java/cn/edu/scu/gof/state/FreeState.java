package cn.edu.scu.gof.state;

public class FreeState implements State {

    @Override
    public void handle() {
        System.out.println("房间处于空闲状态！");
    }
}
