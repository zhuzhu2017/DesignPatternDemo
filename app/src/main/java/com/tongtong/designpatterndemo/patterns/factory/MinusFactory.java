package com.tongtong.designpatterndemo.patterns.factory;

import com.tongtong.designpatterndemo.patterns.simplefactory.operations.Operation;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationMinus;

/**
 * 减法工厂类
 * Created by allen on 2017/11/14.
 */

public class MinusFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationMinus();
    }
}
