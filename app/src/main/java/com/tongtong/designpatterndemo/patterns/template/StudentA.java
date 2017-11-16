package com.tongtong.designpatterndemo.patterns.template;

/**
 * 学生A答题
 * Created by allen on 2017/11/16.
 */

public class StudentA extends TestQuestion {

    private String result;

    public StudentA(String result) {
        this.result = result;
    }

    @Override
    public String studentOperation() {
        return "结果：" + result + "=0";
    }
}
