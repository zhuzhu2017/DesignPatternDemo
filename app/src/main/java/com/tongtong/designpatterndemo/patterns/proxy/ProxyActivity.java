package com.tongtong.designpatterndemo.patterns.proxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;
import com.tongtong.designpatterndemo.patterns.proxy.mm.Mm;
import com.tongtong.designpatterndemo.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 代理模式：
 * 为其他对象提供一种代理以控制对这个对象的访问
 * Created by allen on 2017/11/11.
 */

public class ProxyActivity extends AppCompatActivity {
    @BindView(R.id.sp_gg)
    Spinner spGg;
    @BindView(R.id.sp_proxy)
    Spinner spProxy;
    @BindView(R.id.sp_mm)
    Spinner spMm;
    @BindView(R.id.btn_pursuit)
    Button btnPursuit;
    @BindView(R.id.tv_pursuit_result)
    TextView tvPursuitResult;

    private String[] gg = new String[]{"小高"};
    private String[] proxy = new String[]{"小李"};
    private String[] mm = new String[]{"小麦"};
    private ArrayList<String> ggList = new ArrayList<>();
    private ArrayList<String> proxyList = new ArrayList<>();
    private ArrayList<String> mmList = new ArrayList<>();
    private String selectedGg;
    private String selectedProxy;
    private String selectedMm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        ButterKnife.bind(this);
        setTitle("代理模式（追求者案例）");
        ggList.addAll(Arrays.asList(gg));
        proxyList.addAll(Arrays.asList(proxy));
        mmList.addAll(Arrays.asList(mm));
        //设置数据
        spGg.setDropDownVerticalOffset(DisplayUtil.dip2px(this, 40));
        spProxy.setDropDownVerticalOffset(DisplayUtil.dip2px(this, 40));
        spMm.setDropDownVerticalOffset(DisplayUtil.dip2px(this, 40));
        spGg.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, ggList));
        spProxy.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, proxyList));
        spMm.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, mmList));
        //初始化选中
        selectedGg = gg[0];
        selectedProxy = proxy[0];
        selectedMm = mm[0];
        //添加选中监听
        initListener();
    }

    private void initListener() {
        spGg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGg = ggList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spProxy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedProxy = proxyList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spMm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMm = mmList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @OnClick(R.id.btn_pursuit)
    public void onViewClicked() {
        Mm mm = new Mm();
        mm.setName(selectedMm);
        Proxy proxy = new Proxy(mm);
        String giveDolls = proxy.giveDolls();
        String giveFlowers = proxy.giveFlowers();
        String watchFilm = proxy.watchFilm();
        tvPursuitResult.setText(selectedGg + giveDolls + "\n"
                + selectedGg + giveFlowers + "\n"
                + selectedGg + watchFilm);
    }
}
