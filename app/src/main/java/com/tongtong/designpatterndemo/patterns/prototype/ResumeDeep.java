package com.tongtong.designpatterndemo.patterns.prototype;

/**
 * 简历类（采用深复制实现）
 * Created by allen on 2017/11/15.
 */

public class ResumeDeep implements Cloneable {

    private String name;
    private String sex;
    private String age;
    private WorkExperienceDeep work;

    public String toString() {
        return "姓名：" + name +
                ",性别：" + sex +
                ", 年龄：" + age + "\n" +
                "工作经历：" + work.getWorkDate() + "," + work.getCompany();
    }

    public ResumeDeep(String name) {
        this.name = name;
        work = new WorkExperienceDeep();
    }

    public ResumeDeep(WorkExperienceDeep work) {
        try {
            this.work = (WorkExperienceDeep) work.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
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
        ResumeDeep resume = new ResumeDeep(this.work);
        resume.name = this.name;
        resume.sex = this.sex;
        resume.age = this.age;
        return resume;
    }
}
