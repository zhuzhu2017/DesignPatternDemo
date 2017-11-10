package com.tongtong.designpatterndemo.patterns.strategy.concrete;

/**
 * 满减算法类
 * Created by allen on 2017/11/10.
 */

public class CashReduce extends CashSuper {

    private double reachMoney = 0d; //达到的金额
    private double reduceMoney = 0d;    //减去的金额

    public CashReduce(String reachMoney, String reduceMoney) {
        if (reachMoney != null) this.reachMoney = Double.valueOf(reachMoney);
        if (reduceMoney != null) this.reduceMoney = Double.valueOf(reduceMoney);
    }

    /**
     * 如果商品总金额>=满减的金额条件，则减去相应的金额
     * 实现一种比较简单的算法：不管总金额超过满减条件多少，都只减去满减的金额
     *
     * @param money 商品总金额
     * @return 优惠后的金额
     */
    @Override
    public double getCashResult(double money) {
        if (money >= reachMoney) {
            return money - reduceMoney;
        }
        return money;
    }
}
