package cn.edu.scu.gof.chain;

public class GeneralManager extends Leader {


    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDay() < 30) {
            System.out.println("员工：" + leaveRequest.getName() + ",请假" + leaveRequest.getLeaveDay() + "天，理由：" + leaveRequest.getReason());
            System.out.println("总经理：" + this.name + "审批通过");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}
