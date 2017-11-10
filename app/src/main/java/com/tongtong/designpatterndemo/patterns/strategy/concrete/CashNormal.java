package com.tongtong.designpatterndemo.patterns.strategy.concrete;

/**
 * 正常收费
 * Created by allen on 2017/11/10.
 */

public class CashNormal extends CashSuper {

    @Override
    public double getCashResult(double money) {
        return money;
    }
}
