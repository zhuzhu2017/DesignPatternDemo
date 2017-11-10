package com.tongtong.designpatterndemo.patterns.strategy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
    @BindView(R.id.tv_scores)
    TextView tvScores;

    private ArrayList<String> yhList = new ArrayList<>();
    private ArrayList<String> resultList = new ArrayList<>();
    private String selectedYh;  //选中的优惠类型

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
        yhList.add("无优惠");
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
                selectedYh = yhList.get(i);
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
                /**
                 * 操作：获取输入的商品单价个数量；
                 * 获取最终结果并设置UI显示
                 */
                String price = etGoodsPrice.getText().toString().trim();
                String num = etGoodsNum.getText().toString().trim();
                CashContext cashContext = new CashContext(selectedYh);
                double result = cashContext.getResult(Double.valueOf(price) * Double.valueOf(num));
                int scores = cashContext.getScores(Double.valueOf(price) * Double.valueOf(num));
                resultList.add("商品单价：" + price);
                resultList.add("商品数量：" + num);
                resultList.add("优惠类型：" + selectedYh);
                resultList.add("赠送积分：" + scores);
                //设置结果展示
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList);
                lvPayDetails.setAdapter(arrayAdapter);
                tvPayMoney.setText(result + "");
                tvScores.setText(scores + "");
                break;
            case R.id.btn_reset:
                selectedYh = null;
                etGoodsPrice.setText(null);
                etGoodsNum.setText(null);
                tvPayMoney.setText(null);
                tvScores.setText(null);
                resultList.clear();
                lvPayDetails.setAdapter(null);
                spYhCategory.setSelection(0);
                etGoodsPrice.requestFocus();
                break;
        }
    }
}
