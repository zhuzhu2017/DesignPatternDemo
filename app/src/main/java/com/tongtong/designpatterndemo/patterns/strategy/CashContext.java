package com.tongtong.designpatterndemo.patterns.strategy;

import com.tongtong.designpatterndemo.patterns.strategy.concrete.CashNormal;
import com.tongtong.designpatterndemo.patterns.strategy.concrete.CashRebate;
import com.tongtong.designpatterndemo.patterns.strategy.concrete.CashReduce;
import com.tongtong.designpatterndemo.patterns.strategy.concrete.CashSuper;
import com.tongtong.designpatterndemo.patterns.strategy.concrete.ScoresReturn;

/**
 * 简单工厂模式与策略模式相结合(与客户端直接接触的类)
 * Created by allen on 2017/11/10.
 */

public class CashContext {

    private CashSuper cs;

    public CashContext(String type) {
        if (type != null) {
            switch (type) {
                case "无优惠":
                    cs = new CashNormal();
                    break;
                case "满500减200":
                    cs = new CashReduce("500", "200");
                    break;
                case "满300减100":
                    cs = new CashReduce("300", "100");
                    break;
                case "打九折":
                    cs = new CashRebate("0.9");
                    break;
                case "打五折":
                    cs = new CashRebate("0.5");
                    break;
                case "满100返10积分":
                    cs = new ScoresReturn("100", "10");
                    break;
            }
        }
    }

    public double getResult(double money) {
        if (cs != null) {
            return cs.getCashResult(money);
        }
        return 0d;
    }

    public int getScores(double money) {
        if (cs != null && cs instanceof ScoresReturn) {
            ScoresReturn scoresReturn = (ScoresReturn) cs;
            return scoresReturn.getReturnScores();
        }
        return 0;
    }

}
