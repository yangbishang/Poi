package com.ygoa.pojo;

import java.sql.Date;

public class Employees {
    private int empNo;
    private String passWord;
    private String eName;
    private String sex;
    private String education;
    private String phone;
    private String picture;
    private String address;
    private String email;
    private int roleId;
    private String job;
    private int deptNo;
    private Date  birthday;
    private String idCard;
    private Date hiredate;
    private String isMarried;
    private Double holiday;
    private String remarks;

    @Override
    public String toString() {
        return "Employees{" +
                "empNo=" + empNo +
                ", passWord='" + passWord + '\'' +
                ", eName='" + eName + '\'' +
                ", sex='" + sex + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                ", job='" + job + '\'' +
                ", deptNo=" + deptNo +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", hiredate=" + hiredate +
                ", isMarried='" + isMarried + '\'' +
                ", holiday=" + holiday +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(String isMarried) {
        this.isMarried = isMarried;
    }

    public Double getHoliday() {
        return holiday;
    }

    public void setHoliday(Double holiday) {
        this.holiday = holiday;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
