package com.tongtong.designpatterndemo.patterns.decorator;

/**
 * 人物类
 * Created by allen on 2017/11/11.
 */

public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String show() {
        return "装扮的" + name;
    }
}
