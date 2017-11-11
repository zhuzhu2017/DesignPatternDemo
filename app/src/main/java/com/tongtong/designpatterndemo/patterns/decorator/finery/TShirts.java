package com.tongtong.designpatterndemo.patterns.decorator.finery;

/**
 * 大T恤（设置为单例对象，简单化不考虑person有好几件T恤）
 * Created by allen on 2017/11/11.
 */

public class TShirts extends Finery {

    private static TShirts instance;

    private TShirts() {
    }

    public static TShirts getInstance() {
        if (instance == null) {
            synchronized (TShirts.class) {
                if (instance == null) {
                    instance = new TShirts();
                }
            }
        }
        return instance;
    }

    @Override
    public String show() {
        return "大T恤".concat(super.show());
    }
}
