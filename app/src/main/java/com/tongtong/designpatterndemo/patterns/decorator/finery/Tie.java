package com.tongtong.designpatterndemo.patterns.decorator.finery;

/**
 * 领带
 * Created by allen on 2017/11/11.
 */

public class Tie extends Finery {

    private static Tie instance;

    private Tie() {
    }

    public static Tie getInstance() {
        if (instance == null) {
            synchronized (Tie.class) {
                if (instance == null) {
                    instance = new Tie();
                }
            }
        }
        return instance;
    }

    @Override
    public String show() {
        return "领带".concat(super.show());
    }
}
