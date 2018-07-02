package com.ygoa.pojo;

import java.util.Date;

public class Report {
    private int rnumb;
    private int empno;
    private String ename;
    private int clockIn;
    private int normalClockIn;
    private int later;
    private int leaveEarlier;
    private int leaveTime;
    private int approvalTime;
    private int deptno;
    private Date rDate;

    public int getRnumb() {
        return rnumb;
    }

    public void setRnumb(int rnumb) {
        this.rnumb = rnumb;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getClockIn() {
        return clockIn;
    }

    public void setClockIn(int clockIn) {
        this.clockIn = clockIn;
    }

    public int getNormalClockIn() {
        return normalClockIn;
    }

    public void setNormalClockIn(int normalClockIn) {
        this.normalClockIn = normalClockIn;
    }

    public int getLater() {
        return later;
    }

    public void setLater(int later) {
        this.later = later;
    }

    public int getLeaveEarlier() {
        return leaveEarlier;
    }

    public void setLeaveEarlier(int leaveEarlier) {
        this.leaveEarlier = leaveEarlier;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(int approvalTime) {
        this.approvalTime = approvalTime;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }
}
