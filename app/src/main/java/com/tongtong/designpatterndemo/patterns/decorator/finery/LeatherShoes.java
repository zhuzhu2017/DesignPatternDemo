package com.tongtong.designpatterndemo.patterns.decorator.finery;

/**
 * 皮鞋
 * Created by allen on 2017/11/11.
 */

public class LeatherShoes extends Finery {

    private static LeatherShoes instance;

    private LeatherShoes() {
    }

    public static LeatherShoes getInstance() {
        if (instance == null) {
            synchronized (LeatherShoes.class) {
                if (instance == null) {
                    instance = new LeatherShoes();
                }
            }
        }
        return instance;
    }

    @Override
    public String show() {
        return "皮鞋".concat(super.show());
    }
}
