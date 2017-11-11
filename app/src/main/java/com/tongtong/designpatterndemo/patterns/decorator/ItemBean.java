package com.tongtong.designpatterndemo.patterns.decorator;

import java.io.Serializable;

/**
 * 穿着数据对象
 * Created by allen on 2017/11/11.
 */

public class ItemBean implements Serializable {
    private String text;
    private boolean isChecked;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
