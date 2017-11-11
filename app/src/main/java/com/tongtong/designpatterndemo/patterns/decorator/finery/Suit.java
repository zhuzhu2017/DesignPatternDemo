package com.tongtong.designpatterndemo.patterns.decorator.finery;

/**
 * 西服
 * Created by allen on 2017/11/11.
 */

public class Suit extends Finery {
    private static Suit instance;

    private Suit() {
    }

    public static Suit getInstance() {
        if (instance == null) {
            synchronized (Suit.class) {
                if (instance == null) {
                    instance = new Suit();
                }
            }
        }
        return instance;
    }
    @Override
    public String show() {
        return "西服".concat(super.show());
    }
}
