package com.tongtong.designpatterndemo.patterns.decorator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;
import com.tongtong.designpatterndemo.patterns.decorator.factory.DecoratorFactory;
import com.tongtong.designpatterndemo.patterns.decorator.finery.Finery;
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
    private ArrayList<Finery> selectedDecoratorList = new ArrayList<>();
    private GridAdapter adapter;
    private String selectedName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);
        ButterKnife.bind(this);
        setTitle("装饰者模式（模拟装饰人物穿着）");
        //初始化人物为第一个
        selectedName = people[0];
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
                Finery finery = DecoratorFactory.createFinery(decoratorList.get(position).getText());
                selectedDecoratorList.add(finery);
            }

            @Override
            public void onCanceled(int position) {
                Finery finery = DecoratorFactory.createFinery(decoratorList.get(position).getText());
                if (selectedDecoratorList.contains(finery))
                    selectedDecoratorList.remove(finery);
            }
        });
        //选中人物监听
        spPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedName = peopleList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @OnClick({R.id.btn_decorator, R.id.btn_reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_decorator:
                Person person = new Person(selectedName);
                Finery finery = null;
                if (selectedDecoratorList.size() > 1) {
                    for (int i = 0; i < selectedDecoratorList.size(); i++) {
                        if (i == 0) {
                            selectedDecoratorList.get(0).Decorate(person);
                        } else {
                            if (i + 1 < selectedDecoratorList.size()) {   //表示不是最后一个
                                selectedDecoratorList.get(i + 1).Decorate(selectedDecoratorList.get(i));
                            } else { //最后一个
                                selectedDecoratorList.get(selectedDecoratorList.size() - 1)
                                        .Decorate(selectedDecoratorList.get(selectedDecoratorList.size() - 2));
                                finery = selectedDecoratorList.get(selectedDecoratorList.size() - 1);
                            }
                        }
                    }
                } else if (selectedDecoratorList.size() > 0) {
                    selectedDecoratorList.get(0).Decorate(person);
                    finery = selectedDecoratorList.get(0);
                } else {
                    finery = null;
                }
                if (finery != null) {
                    String showString = finery.show();
                    tvResult.setText(showString);
                } else {
                    tvResult.setText("光着身子的" + selectedName);
                }
                break;
            case R.id.btn_reset:
                //重置穿着选择状态
                selectedDecoratorList.clear();
                for (ItemBean bean :
                        decoratorList) {
                    bean.setChecked(false);
                }
                if (adapter != null) adapter.updateGrid(decoratorList);
                tvResult.setText(null);
                break;
        }
    }
}
