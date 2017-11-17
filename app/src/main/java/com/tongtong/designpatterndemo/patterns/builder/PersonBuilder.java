package com.tongtong.designpatterndemo.patterns.builder;

/**
 * 构建人物接口
 * Created by allen on 2017/11/17.
 */

public interface PersonBuilder {
    PersonBuilder setName(String name);

    PersonBuilder setSex(String sex);

    PersonBuilder setAge(String age);

    PersonBuilder setHeight(String height);

    PersonBuilder setWeight(String weight);

    Person createPerson();

    String showString();
}
