package com.ygoa.pojo;

import java.io.Serializable;
import java.util.Date;

public class Leaves implements Serializable{//请假条

    private Integer leaveId;//主键
    private Integer empno;//员工表主键
    private Integer ltId;//类型表主键
    private Date leaveTime;//开始时间
    private Double days;//请假天数
    private String reason;//事由
    private Integer state;//请假条状态（0:审批中，1:已批准，2:被否决）

    public Leaves() {
    }

    public Leaves(Integer leaveId, Integer empno, Integer ltId, Date leaveTime, Double days, String reason, Integer state) {
        this.leaveId = leaveId;
        this.empno = empno;
        this.ltId = ltId;
        this.leaveTime = leaveTime;
        this.days = days;
        this.reason = reason;
        this.state = state;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getLtId() {
        return ltId;
    }

    public void setLtId(Integer ltId) {
        this.ltId = ltId;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        this.days = days;
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

    @Override
    public String toString() {
        return "Leaves{" +
                "leaveId=" + leaveId +
                ", empno=" + empno +
                ", ltId=" + ltId +
                ", leaveTime=" + leaveTime +
                ", days=" + days +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                '}';
    }
}
