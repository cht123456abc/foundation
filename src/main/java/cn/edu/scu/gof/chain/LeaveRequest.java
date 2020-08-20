package cn.edu.scu.gof.chain;

/**
 * 封装请加条的基本信息
 */
public class LeaveRequest {

    private String name;
    private int leaveDay;
    private String reason;

    public LeaveRequest(String name, int leaveDay, String reason) {
        this.name = name;
        this.leaveDay = leaveDay;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(int leaveDay) {
        this.leaveDay = leaveDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
