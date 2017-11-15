package com.tongtong.designpatterndemo.patterns.prototype;

/**
 * 简历类
 * Created by allen on 2017/11/15.
 */

public class Resume implements Cloneable {

    private String name;
    private String sex;
    private String age;
    private WorkExperience work;

    public String toString() {
        return "姓名：" + name +
                ",性别：" + sex +
                ", 年龄：" + age + "\n" +
                "工作经历：" + work.getWorkDate() + "," + work.getCompany();
    }

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    //设置个人信息
    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    //设置工作经历
    public void setWorkExperience(String workDate, String company) {
        work.setWorkDate(workDate);
        work.setCompany(company);
    }

    //显示
    public String display() {
        return this.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
