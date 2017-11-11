package com.tongtong.designpatterndemo.patterns.decorator.finery;

import com.tongtong.designpatterndemo.patterns.decorator.Person;

/**
 * 服装父类
 * Created by allen on 2017/11/11.
 */

public class Finery extends Person {

    protected Person person;

    public void Decorate(Person person) {
        this.person = person;
    }

    @Override
    public String show() {
        if (person != null) {
            return person.show();
        }
        return super.show();
    }
}
