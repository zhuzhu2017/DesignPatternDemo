package com.tongtong.designpatterndemo.patterns.builder;

/**
 * Created by allen on 2017/11/17.
 */

public class PersonDirector {
    private PersonBuilder builder;

    public PersonDirector(PersonBuilder builder) {
        this.builder = builder;
    }

    public String construct(String name, String sex, String age, String height, String weight) {
        builder.setName(name);
        builder.setSex(sex);
        builder.setAge(age);
        builder.setHeight(height);
        builder.setWeight(weight);
        return builder.showString();
    }

}
