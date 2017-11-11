package com.tongtong.designpatterndemo.patterns.proxy;

import com.tongtong.designpatterndemo.patterns.proxy.inter.IGift;
import com.tongtong.designpatterndemo.patterns.proxy.mm.Mm;
import com.tongtong.designpatterndemo.patterns.proxy.pursuiter.XiaoGao;

/**
 * 代理
 * Created by allen on 2017/11/11.
 */

public class Proxy implements IGift {
    private XiaoGao xiaoGao;

    public Proxy(Mm mm) {
        xiaoGao = new XiaoGao(mm);
    }

    @Override
    public String giveDolls() {
        return xiaoGao.giveDolls();
    }

    @Override
    public String giveFlowers() {
        return xiaoGao.giveFlowers();
    }

    @Override
    public String watchFilm() {
        return xiaoGao.watchFilm();
    }
}
