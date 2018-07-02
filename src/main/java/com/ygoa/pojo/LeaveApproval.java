package com.ygoa.pojo;

import java.io.Serializable;
import java.util.Date;

//请假审批记录表
public class LeaveApproval implements Serializable{
    private Integer lapprId;//主键
    private Integer leaveId;//请假条表主键
    private Date lapprTime;//审批时间
    private String reason;//理由
    private Integer state;//审批状态
    private Integer empno;//审批人用户Id (员工表)

    public LeaveApproval() {
    }

    public LeaveApproval(Integer lapprId, Integer leaveId, Date lapprTime, String reason, Integer state, Integer empno) {
        this.lapprId = lapprId;
        this.leaveId = leaveId;
        this.lapprTime = lapprTime;
        this.reason = reason;
        this.state = state;
        this.empno = empno;
    }

    public Integer getLapprId() {
        return lapprId;
    }

    public void setLapprId(Integer lapprId) {
        this.lapprId = lapprId;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Date getLapprTime() {
        return lapprTime;
    }

    public void setLapprTime(Date lapprTime) {
        this.lapprTime = lapprTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    @Override
    public String toString() {
        return "LeaveApproval{" +
                "lapprId=" + lapprId +
                ", leaveId=" + leaveId +
                ", lapprTime=" + lapprTime +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                ", empno=" + empno +
                '}';
    }
}
