package com.tongtong.designpatterndemo.patterns.facade;

/**
 * 外观类
 * Created by allen on 2017/11/16.
 */

public class Facade {

    private StockA stockA;
    private StockB stockB;
    private StockC stockC;

    public Facade() {
        stockA = new StockA();
        stockB = new StockB();
        stockC = new StockC();
    }

    public String buy() {
        return stockA.buy() + "," + stockC.buy();
    }

    public String sell() {
        return stockA.sell() + "," + stockC.sell();
    }

}
