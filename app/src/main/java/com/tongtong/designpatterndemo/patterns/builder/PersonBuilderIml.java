package com.tongtong.designpatterndemo.patterns.builder;

/**
 * 接口实现类
 * Created by allen on 2017/11/17.
 */

public class PersonBuilderIml implements PersonBuilder {

    private String name;
    private String sex;
    private String age;
    private String height;
    private String weight;

    @Override
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder setSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public PersonBuilder setAge(String age) {
        this.age = age;
        return this;
    }

    @Override
    public PersonBuilder setHeight(String height) {
        this.height = height;
        return this;
    }

    @Override
    public PersonBuilder setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public Person createPerson() {
        return new Person(name, sex, age, height, weight);
    }

    @Override
    public String showString() {
        return "创建对象：\n" + "姓名：" + name + "\n性别：" + sex +
                "\n年龄：" + age + "\n身高：" + height + "\n体重：" + weight;
    }
}
