package cn.edu.scu.gof.commond;

public interface Command {

    /**
     * 执行命令的方法
     */
    void execute();
}

class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
