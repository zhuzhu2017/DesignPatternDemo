package com.tongtong.designpatterndemo.patterns.template;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 模板方法模式：
 * 定义一个操作中的算法的骨架，而将这一步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 * Created by allen on 2017/11/15.
 */

public class TemplateActivity extends AppCompatActivity {
    @BindView(R.id.et_studentA_answer)
    EditText etStudentAAnswer;
    @BindView(R.id.btn_studentA)
    Button btnStudentA;
    @BindView(R.id.tv_studentA_result)
    TextView tvStudentAResult;
    @BindView(R.id.et_studentB_answer)
    EditText etStudentBAnswer;
    @BindView(R.id.btn_studentB)
    Button btnStudentB;
    @BindView(R.id.tv_studentB_result)
    TextView tvStudentBResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        ButterKnife.bind(this);
        setTitle("模板方法模式（不同学生答同一题）");
    }

    @OnClick({R.id.btn_studentA, R.id.btn_studentB})
    public void onViewClicked(View view) {
        String answerA = etStudentAAnswer.getText().toString().trim();
        String answerB = etStudentBAnswer.getText().toString().trim();
        switch (view.getId()) {
            case R.id.btn_studentA:
                TestQuestion studentA = new StudentA(answerA);
                String resultA = studentA.templateMethod();
                tvStudentAResult.setText(resultA);
                break;
            case R.id.btn_studentB:
                TestQuestion studentB = new StudentB(answerB);
                String resultB = studentB.templateMethod();
                tvStudentBResult.setText(resultB);
                break;
        }
    }
}
