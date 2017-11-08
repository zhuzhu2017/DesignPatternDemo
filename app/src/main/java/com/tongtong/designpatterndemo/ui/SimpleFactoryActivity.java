package com.tongtong.designpatterndemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.designpatterndemo.R;

/**
 * 简单工厂模式
 * Created by allen on 2017/11/8.
 */

public class SimpleFactoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_factory);
    }
}
