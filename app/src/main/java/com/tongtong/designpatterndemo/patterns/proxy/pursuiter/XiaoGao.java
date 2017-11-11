package com.tongtong.designpatterndemo.patterns.proxy.pursuiter;

import com.tongtong.designpatterndemo.patterns.proxy.inter.IGift;
import com.tongtong.designpatterndemo.patterns.proxy.mm.Mm;

/**
 * 追求者小高
 * Created by allen on 2017/11/11.
 */

public class XiaoGao implements IGift {

    private Mm mm;

    public XiaoGao(Mm mm) {
        this.mm = mm;
    }

    @Override
    public String giveDolls() {
        return "送洋娃娃给" + mm.getName();
    }

    @Override
    public String giveFlowers() {
        return "送鲜花给" + mm.getName();
    }

    @Override
    public String watchFilm() {
        return "跟" + mm.getName() + "一起去看电影";
    }
}
