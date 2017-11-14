package com.tongtong.designpatterndemo.patterns.factory;

import com.tongtong.designpatterndemo.patterns.simplefactory.operations.Operation;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationAdd;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.OperationMul;

/**
 * 乘法运算工厂
 * Created by allen on 2017/11/14.
 */

public class MulFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationMul();
    }
}
