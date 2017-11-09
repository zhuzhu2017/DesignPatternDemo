package com.tongtong.designpatterndemo.patterns.simplefactory.operations;

/**
 * 运算父类（抽象类）
 * Created by allen on 2017/11/9.
 */

public abstract class Operation {
    private double numberA;
    private double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public abstract double getResult();

}
