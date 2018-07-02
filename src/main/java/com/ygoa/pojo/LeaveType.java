package com.ygoa.pojo;

import java.io.Serializable;

//假期类型表
public class LeaveType implements Serializable{

    private Integer ltId;//主键
    private String ltValue;//假期类型

    public LeaveType() {
    }

    public LeaveType(Integer ltId, String ltValue) {
        this.ltId = ltId;
        this.ltValue = ltValue;
    }

    public Integer getLtId() {
        return ltId;
    }

    public void setLtId(Integer ltId) {
        this.ltId = ltId;
    }

    public String getLtValue() {
        return ltValue;
    }

    public void setLtValue(String ltValue) {
        this.ltValue = ltValue;
    }

    @Override
    public String toString() {
        return "LeaveType{" +
                "ltId=" + ltId +
                ", ltValue='" + ltValue + '\'' +
                '}';
    }
}
