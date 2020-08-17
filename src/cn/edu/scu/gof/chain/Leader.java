package cn.edu.scu.gof.chain;


/**
 * 抽象类,abstract,当该类的某些方法暂时不确定具体的实现时，使用abstract
 */
public abstract class Leader {

    protected String name;
    protected Leader nextLeader;// 责任链上的后继对象

    public abstract void handleRequest(LeaveRequest leaveRequest);

    public Leader(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
}
