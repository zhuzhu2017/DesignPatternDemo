package com.tongtong.designpatterndemo.patterns.decorator.factory;

import com.tongtong.designpatterndemo.patterns.decorator.finery.BigTrouser;
import com.tongtong.designpatterndemo.patterns.decorator.finery.BrokenShoes;
import com.tongtong.designpatterndemo.patterns.decorator.finery.Finery;
import com.tongtong.designpatterndemo.patterns.decorator.finery.LeatherShoes;
import com.tongtong.designpatterndemo.patterns.decorator.finery.Suit;
import com.tongtong.designpatterndemo.patterns.decorator.finery.TShirts;
import com.tongtong.designpatterndemo.patterns.decorator.finery.Tie;

/**
 * 简单工厂设计模式结合
 * Created by allen on 2017/11/11.
 */

public class DecoratorFactory {

    private static Finery finery;

    /**
     * 创建服饰对象
     * (默认每件服饰只有一件)
     *
     * @param type
     * @return
     */
    public static Finery createFinery(String type) {
        switch (type) {
            case "大T恤":
                finery = TShirts.getInstance();
                break;
            case "垮裤":
                finery = BigTrouser.getInstance();
                break;
            case "破球鞋":
                finery = BrokenShoes.getInstance();
                break;
            case "西装":
                finery = Suit.getInstance();
                break;
            case "领带":
                finery = Tie.getInstance();
                break;
            case "皮鞋":
                finery = LeatherShoes.getInstance();
                break;
        }
        return finery;
    }

}
