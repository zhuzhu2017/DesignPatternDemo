package com.tongtong.designpatterndemo.patterns.factory;

import com.tongtong.designpatterndemo.patterns.simplefactory.operations.Operation;

/**
 * 工厂接口(Operation类和具体的运算类与简单工厂模式的一致)
 * Created by allen on 2017/11/14.
 */

public interface IFactory {

    Operation createOperation();

}
