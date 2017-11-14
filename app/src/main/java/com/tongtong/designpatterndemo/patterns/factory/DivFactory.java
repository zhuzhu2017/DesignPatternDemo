package com.tongtong.designpatterndemo.patterns.factory;

import com.tongtong.designpatterndemo.patterns.simplefactory.operations.Operation;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationDiv;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationMul;

/**
 * 除法运算工厂
 * Created by allen on 2017/11/14.
 */

public class DivFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
