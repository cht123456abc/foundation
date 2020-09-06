package cn.edu.scu.gof.chain;

/**
 * 主任
 */
public class Director extends Leader {

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDay() < 3) {
            System.out.println("员工：" + leaveRequest.getName() + ",请假" + leaveRequest.getLeaveDay() + "天，理由：" + leaveRequest.getReason());
            System.out.println("主任：" + this.name + "审批通过");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }

    public Director(String name) {
        super(name);
    }

}
