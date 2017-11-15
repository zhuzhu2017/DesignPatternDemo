package com.tongtong.designpatterndemo.patterns.prototype;

/**
 * 深复制工作经验类
 * Created by allen on 2017/11/15.
 */

public class WorkExperienceDeep implements Cloneable {

    private String workDate;
    private String company;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
