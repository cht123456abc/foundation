package cn.edu.scu.gof.commond;

public class Invoke {

    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}
