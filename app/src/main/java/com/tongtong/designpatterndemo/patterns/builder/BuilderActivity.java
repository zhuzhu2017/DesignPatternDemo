package com.tongtong.designpatterndemo.patterns.builder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;
import com.tongtong.designpatterndemo.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 建造者模式：
 * 将一个复杂对象的构建与它的表示分离，
 * 使得同样的构建过程能创建不同的表示
 * Created by allen on 2017/11/16.
 */

public class BuilderActivity extends AppCompatActivity {

    @BindView(R.id.et_input_name)
    EditText etInputName;
    @BindView(R.id.sp_select_sex)
    Spinner spSelectSex;
    @BindView(R.id.et_input_age)
    EditText etInputAge;
    @BindView(R.id.et_input_height)
    EditText etInputHeight;
    @BindView(R.id.et_input_weight)
    EditText etInputWeight;
    @BindView(R.id.btn_build)
    Button btnBuild;
    @BindView(R.id.tv_build_result)
    TextView tvBuildResult;

    private ArrayList<String> sexList = new ArrayList<>();
    private String[] sexs = new String[]{"男", "女", "外星人"};
    private String selectedSex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
        ButterKnife.bind(this);
        setTitle("建造者模式（创建人物）");
        sexList.addAll(Arrays.asList(sexs));
        //设置数据
        spSelectSex.setDropDownVerticalOffset(DisplayUtil.dip2px(this, 40));
        spSelectSex.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, sexList));
        spSelectSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSex = sexList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @OnClick(R.id.btn_build)
    public void onViewClicked() {
        //获取参数
        String name = etInputName.getText().toString().trim();
        String age = etInputAge.getText().toString().trim();
        String height = etInputHeight.getText().toString().trim();
        String weight = etInputWeight.getText().toString().trim();
        PersonBuilder builder = new PersonBuilderIml();
        PersonDirector director = new PersonDirector(builder);
        String construct = director.construct(name, selectedSex, age, height, weight);
        tvBuildResult.setText(construct);
    }
}
