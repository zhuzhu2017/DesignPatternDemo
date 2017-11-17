package com.tongtong.designpatterndemo.patterns.builder;

/**
 * 人物产品类
 * Created by allen on 2017/11/17.
 */

public class Person {
    private String name;
    private String sex;
    private String age;
    private String height;
    private String weight;

    public Person(String name, String sex, String age, String height, String weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
