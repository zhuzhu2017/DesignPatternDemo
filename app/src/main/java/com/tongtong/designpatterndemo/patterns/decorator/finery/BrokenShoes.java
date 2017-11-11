package com.tongtong.designpatterndemo.patterns.decorator.finery;

/**
 * 西装
 * Created by allen on 2017/11/11.
 */

public class BrokenShoes extends Finery {

    private static BrokenShoes instance;

    private BrokenShoes() {
    }

    public static BrokenShoes getInstance() {
        if (instance == null) {
            synchronized (BrokenShoes.class) {
                if (instance == null) {
                    instance = new BrokenShoes();
                }
            }
        }
        return instance;
    }

    @Override
    public String show() {
        return "西装".concat(super.show());
    }
}
