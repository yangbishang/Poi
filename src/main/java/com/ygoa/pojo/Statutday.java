package com.ygoa.pojo;

import java.io.Serializable;
import java.util.Date;

//法定假期表
public class Statutday implements Serializable {
    private Integer sdayId;//主键
    private String sdayName;//假期名
    private Date startTime;//开始时间
    private Date endTime;//结束时间

    public Statutday() {
    }

    public Statutday(Integer sdayId, String sdayName, Date startTime, Date endTime) {
        this.sdayId = sdayId;
        this.sdayName = sdayName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getSdayId() {
        return sdayId;
    }

    public void setSdayId(Integer sdayId) {
        this.sdayId = sdayId;
    }

    public String getSdayName() {
        return sdayName;
    }

    public void setSdayName(String sdayName) {
        this.sdayName = sdayName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Statutday{" +
                "sdayId=" + sdayId +
                ", sdayName='" + sdayName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
