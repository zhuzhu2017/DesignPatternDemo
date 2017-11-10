package com.tongtong.designpatterndemo.patterns.strategy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;
import com.tongtong.designpatterndemo.utils.DisplayUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 策略模式
 * Created by allen on 2017/11/9.
 */

public class StrategyActivity extends AppCompatActivity {
    @BindView(R.id.et_goods_price)
    EditText etGoodsPrice;
    @BindView(R.id.et_goods_num)
    EditText etGoodsNum;
    @BindView(R.id.sp_yh_category)
    Spinner spYhCategory;
    @BindView(R.id.lv_pay_details)
    ListView lvPayDetails;
    @BindView(R.id.tv_pay_money)
    TextView tvPayMoney;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.btn_reset)
    Button btnReset;

    private ArrayList<String> yhList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
        ButterKnife.bind(this);
        //设置标题
        setTitle("策略模式（简易商场优惠系统）");
        //设置优惠类型
        initData();
    }

    private void initData() {
        //设置优惠类型
        yhList.add("满500减200");
        yhList.add("满300减100");
        yhList.add("打九折");
        yhList.add("打五折");
        yhList.add("满100返10积分");
        //设置数据
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, yhList);
        //设置样式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spYhCategory.setDropDownVerticalOffset(DisplayUtil.dip2px(this, 40));
        spYhCategory.setAdapter(arrayAdapter);
        spYhCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("选中了", yhList.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @OnClick({R.id.btn_confirm, R.id.btn_reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                break;
            case R.id.btn_reset:
                break;
        }
    }
}
