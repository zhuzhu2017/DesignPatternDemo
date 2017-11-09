package com.tongtong.designpatterndemo.patterns.strategy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 策略模式
 * Created by allen on 2017/11/9.
 */

public class StrategyActivity extends AppCompatActivity {
    @BindView(R.id.et_goods_price)
    EditText etGoodsPrice;
    @BindView(R.id.et_goods_num)
    EditText etGoodsNum;
    @BindView(R.id.et_preferance_type)
    AutoCompleteTextView etPreferanceType;
    @BindView(R.id.lv_pay_details)
    ListView lvPayDetails;
    @BindView(R.id.tv_pay_money)
    TextView tvPayMoney;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
        ButterKnife.bind(this);
        //设置标题
        setTitle("策略模式（简易商场优惠系统）");
    }
}
