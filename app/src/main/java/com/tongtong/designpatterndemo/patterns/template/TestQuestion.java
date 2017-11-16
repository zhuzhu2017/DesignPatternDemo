package com.tongtong.designpatterndemo.patterns.template;

/**
 * 测试题抽象类
 * Created by allen on 2017/11/16.
 */

public abstract class TestQuestion {
    public abstract String studentOperation();

    public String templateMethod() {
        return studentOperation();
    }
}
