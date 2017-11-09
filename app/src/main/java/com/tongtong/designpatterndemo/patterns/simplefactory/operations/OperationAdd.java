package com.tongtong.designpatterndemo.patterns.simplefactory.operations;

/**
 * 加法运算类
 * Created by allen on 2017/11/9.
 */

public class OperationAdd extends Operation {

    @Override
    public double getResult() {
        double numberA = getNumberA();
        double numberB = getNumberB();
        return numberA + numberB;
    }
}
