package com.tongtong.designpatterndemo.patterns.prototype;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 原型设计模式:
 * 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象
 * Created by allen on 2017/11/14.
 */

public class PrototypeActivity extends AppCompatActivity {
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.sp_sex)
    Spinner spSex;
    @BindView(R.id.et_time)
    EditText etTime;
    @BindView(R.id.et_company)
    EditText etCompany;
    @BindView(R.id.btn_light)
    Button btnLight;
    @BindView(R.id.btn_deep)
    Button btnDeep;
    @BindView(R.id.tv_show_result)
    TextView tvShowResult;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_time2)
    EditText etTime2;
    @BindView(R.id.et_company2)
    EditText etCompany2;

    private ArrayList<String> sexList = new ArrayList<>();
    private String selectedSex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prototype);
        ButterKnife.bind(this);
        setTitle("原型模式（简易简历创建模板）");
        //初始化性别
        sexList.add("男");
        sexList.add("女");
        spSex.setDropDownVerticalOffset(DisplayUtil.dip2px(this, 40));
        spSex.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, sexList));
        spSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSex = sexList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @OnClick({R.id.btn_light, R.id.btn_deep})
    public void onViewClicked(View view) {
        String name = etName.getText().toString().trim();
        String time = etTime.getText().toString().trim();
        String company = etCompany.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String time2 = etTime2.getText().toString().trim();
        String company2 = etCompany2.getText().toString().trim();
        switch (view.getId()) {
            case R.id.btn_light:
                Resume resumeA = new Resume(name);
                resumeA.setPersonalInfo(selectedSex, age);
                resumeA.setWorkExperience(time, company);
                //复制
                Resume resumeB = null;
                try {
                    resumeB = (Resume) resumeA.clone();
                    resumeB.setPersonalInfo(selectedSex, age);
                    resumeB.setWorkExperience(time2, company2);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                String displayA = resumeA.display();
                String displayB = null;
                if (resumeB != null) {
                    displayB = resumeB.display();
                }
                tvShowResult.setText(displayA + "\n" + displayB);
                break;
            case R.id.btn_deep:
                ResumeDeep resumeDeepA = new ResumeDeep(name);
                resumeDeepA.setPersonalInfo(selectedSex, age);
                resumeDeepA.setWorkExperience(time, company);
                //深复制
                ResumeDeep resumeDeepB = null;
                try {
                    resumeDeepB = (ResumeDeep) resumeDeepA.clone();
                    resumeDeepB.setWorkExperience(time2, company2);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                String displayDeepA = resumeDeepA.display();
                String displayDeepB = null;
                if (resumeDeepB != null) {
                    displayDeepB = resumeDeepB.display();
                }
                tvShowResult.setText(displayDeepA + "\n" + displayDeepB);
                break;
        }
    }
}
