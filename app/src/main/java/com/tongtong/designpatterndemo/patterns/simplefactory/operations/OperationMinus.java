package com.tongtong.designpatterndemo.patterns.simplefactory.operations;

/**
 * 除法运算类
 * Created by allen on 2017/11/9.
 */

public class OperationMinus extends Operation {

    @Override
    public double getResult() {
        double numberA = getNumberA();
        double numberB = getNumberB();
        return numberA - numberB;
    }
}
