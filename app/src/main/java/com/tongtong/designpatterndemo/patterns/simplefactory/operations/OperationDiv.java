package com.tongtong.designpatterndemo.patterns.simplefactory.operations;

/**
 * 乘法运算类
 * Created by allen on 2017/11/9.
 */

public class OperationDiv extends Operation {

    @Override
    public double getResult() {
        double numberA = getNumberA();
        double numberB = getNumberB();
        if (numberB == 0) {
            return 0;
        }
        return numberA / numberB;
    }
}
