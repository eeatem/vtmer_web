package com.vtmer.domain;

public class User {
    private Long studentNumber;

    private String avatar;

    private String name;

    private String sex;

    private String grade;

    private String college;

    private String major;

    private String classes;

    private Integer qq;

    private Integer phone;

    private String wechat;

    private String firstVolunteer;

    private String secondVolunteer;

    private Long addTime;

    private String selfIntroduction;

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getFirstVolunteer() {
        return firstVolunteer;
    }

    public void setFirstVolunteer(String firstVolunteer) {
        this.firstVolunteer = firstVolunteer == null ? null : firstVolunteer.trim();
    }

    public String getSecondVolunteer() {
        return secondVolunteer;
    }

    public void setSecondVolunteer(String secondVolunteer) {
        this.secondVolunteer = secondVolunteer == null ? null : secondVolunteer.trim();
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction == null ? null : selfIntroduction.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "studentNumber=" + studentNumber +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", qq=" + qq +
                ", phone=" + phone +
                ", wechat='" + wechat + '\'' +
                ", firstVolunteer='" + firstVolunteer + '\'' +
                ", secondVolunteer='" + secondVolunteer + '\'' +
                ", addTime=" + addTime +
                ", selfIntroduction='" + selfIntroduction + '\'' +
                '}';
    }
}