package com.tongtong.designpatterndemo.patterns.decorator.finery;

/**
 * 垮裤
 * Created by allen on 2017/11/11.
 */

public class BigTrouser extends Finery {

    private static BigTrouser instance;

    private BigTrouser() {
    }

    public static BigTrouser getInstance() {
        if (instance == null) {
            synchronized (BigTrouser.class) {
                if (instance == null) {
                    instance = new BigTrouser();
                }
            }
        }
        return instance;
    }

    @Override
    public String show() {
        return "垮裤".concat(super.show());
    }
}
