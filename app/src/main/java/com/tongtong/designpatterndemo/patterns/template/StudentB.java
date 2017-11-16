package com.tongtong.designpatterndemo.patterns.template;

/**
 * Created by allen on 2017/11/16.
 */

public class StudentB extends TestQuestion {

    private String result;

    public StudentB(String result) {
        this.result = result;
    }

    @Override
    public String studentOperation() {
        return "结果：" + result + "=0";
    }
}
