package com.tongtong.designpatterndemo.patterns.strategy.concrete;

/**
 * 打折算法类
 * Created by allen on 2017/11/10.
 */

public class CashRebate extends CashSuper {

    private double moneyRebate = 0d;

    public CashRebate(String moneyRebate) {
        if (moneyRebate != null)
            this.moneyRebate = Double.valueOf(moneyRebate);
    }

    @Override
    public double getCashResult(double money) {
        return money * moneyRebate;
    }
}
