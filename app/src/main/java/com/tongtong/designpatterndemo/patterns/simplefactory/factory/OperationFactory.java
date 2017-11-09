package com.tongtong.designpatterndemo.patterns.simplefactory.factory;

import com.tongtong.designpatterndemo.patterns.simplefactory.operations.Operation;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationAdd;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationDiv;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationMinus;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationMul;

/**
 * 运算方法工厂类
 * Created by allen on 2017/11/9.
 */

public class OperationFactory {
    public static Operation createOperation(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationMinus();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
