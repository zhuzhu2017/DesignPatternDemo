package com.tongtong.designpatterndemo.patterns.prototype;

/**
 * 工作经验父类
 * Created by allen on 2017/11/15.
 */

public class WorkExperience {
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
}
