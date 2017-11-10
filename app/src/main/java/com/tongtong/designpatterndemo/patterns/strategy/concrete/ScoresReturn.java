package com.tongtong.designpatterndemo.patterns.strategy.concrete;

/**
 * 满返积分算法类
 * Created by allen on 2017/11/10.
 */

public class ScoresReturn extends CashSuper {

    private double reachMoney = 0d; //满返金额条件
    private int returnScores = 0;   //返回的积分
    private double totalMoney;  //商品总金额

    public ScoresReturn(String reachMoney, String returnScores) {
        if (reachMoney != null) this.reachMoney = Double.valueOf(reachMoney);
        if (returnScores != null) this.returnScores = Integer.valueOf(returnScores);
    }

    @Override
    public double getCashResult(double money) {
        totalMoney = money;
        return money;
    }

    /**
     * 获取返回的积分
     *
     * @return
     */
    public int getReturnScores() {
        if (totalMoney >= reachMoney) {
            return returnScores;
        }
        return 0;
    }

}
