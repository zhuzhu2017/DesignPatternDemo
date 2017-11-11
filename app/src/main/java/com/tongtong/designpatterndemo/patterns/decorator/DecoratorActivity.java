package com.tongtong.designpatterndemo.patterns.decorator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;
import com.tongtong.designpatterndemo.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 装饰者模式
 * Created by allen on 2017/11/11.
 */

public class DecoratorActivity extends AppCompatActivity {
    @BindView(R.id.sp_person)
    Spinner spPerson;
    @BindView(R.id.btn_decorator)
    Button btnDecorator;
    @BindView(R.id.btn_reset)
    Button btnReset;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.gv_decorator)
    GridView gvDecorator;

    /*初始化数据*/
    private String[] people = new String[]{"小高", "小陈", "小李", "小和"};
    private String[] decorators = new String[]{"大T恤", "垮裤", "破球鞋", "西装", "领带", "皮鞋"};
    private ArrayList<String> peopleList = new ArrayList<>();
    private ArrayList<ItemBean> decoratorList = new ArrayList<>();
    private ArrayList<String> selectedDecoratorList = new ArrayList<>();
    private GridAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);
        ButterKnife.bind(this);
        setTitle("装饰者模式（模拟装饰人物穿着）");
        //初始化数据
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        if (peopleList.size() > 0) peopleList.clear();
        if (decoratorList.size() > 0) decoratorList.clear();
        peopleList.addAll(Arrays.asList(people));
        for (int i = 0; i < decorators.length; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.setChecked(false);
            itemBean.setText(decorators[i]);
            decoratorList.add(itemBean);
        }
        //设置数据
        spPerson.setDropDownVerticalOffset(DisplayUtil.dip2px(this, 40));
        spPerson.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, peopleList));
        adapter = new GridAdapter(this, decoratorList);
        gvDecorator.setAdapter(adapter);
        //添加条目选中监听
        adapter.setIOnSelectedListener(new GridAdapter.IOnSelectedListener() {
            @Override
            public void onSelected(int position) {
                selectedDecoratorList.add(decoratorList.get(position).getText());
            }

            @Override
            public void onCanceled(int position) {
                if (selectedDecoratorList.contains(decoratorList.get(position).getText()))
                    selectedDecoratorList.remove(decoratorList.get(position).getText());
            }
        });
    }

    @OnClick({R.id.btn_decorator, R.id.btn_reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_decorator:
                break;
            case R.id.btn_reset:
                //重置穿着选择状态
                selectedDecoratorList.clear();
                for (ItemBean bean :
                        decoratorList) {
                    bean.setChecked(false);
                }
                if (adapter != null) adapter.updateGrid(decoratorList);
                break;
        }
    }
}
