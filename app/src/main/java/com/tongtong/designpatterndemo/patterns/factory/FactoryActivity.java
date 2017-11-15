package com.tongtong.designpatterndemo.patterns.factory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tongtong.designpatterndemo.R;
import com.tongtong.designpatterndemo.patterns.simplefactory.operations.Operation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工厂模式，实现一个简单的计算器功能（仅仅是两个数之间的加减乘除操作）
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类
 * Created by allen on 2017/11/8.
 */

public class FactoryActivity extends AppCompatActivity {
    @BindView(R.id.et_blank)
    EditText etBlank;
    @BindView(R.id.btn_7)
    Button btn7;
    @BindView(R.id.btn_8)
    Button btn8;
    @BindView(R.id.btn_9)
    Button btn9;
    @BindView(R.id.btn_plus)
    Button btnPlus;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_minus)
    Button btnMinus;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_mul)
    Button btnMul;
    @BindView(R.id.btn_point)
    Button btnPoint;
    @BindView(R.id.btn_0)
    Button btn0;
    @BindView(R.id.btn_result)
    Button btnResult;
    @BindView(R.id.btn_div)
    Button btnDiv;
    @BindView(R.id.btn_clear)
    Button btnClear;

    private Operation operation;    //运算类
    private String numString;   //输入的内容
    private String numAString;
    private String numBString;
    private boolean inputLimit; //输入限制，只允许输入两个数进行运算

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        ButterKnife.bind(this);
        //设置ActionBar显示内容
        setTitle("工厂模式（简易计算器）");
        //设置输入框不能点击
        etBlank.setEnabled(false);
        numString = "";
    }

    @OnClick({R.id.btn_7, R.id.btn_8, R.id.btn_9,
            R.id.btn_plus, R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_minus, R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_mul, R.id.btn_point, R.id.btn_0,
            R.id.btn_result, R.id.btn_div, R.id.btn_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_7:
                numString = numString.concat("7");
                break;
            case R.id.btn_8:
                numString = numString.concat("8");
                break;
            case R.id.btn_9:
                numString = numString.concat("9");
                break;
            case R.id.btn_plus:
                if (!TextUtils.isEmpty(numString)) {
                    if (!inputLimit) {  //表示之前已经输入过运算符
                        inputLimit = true;
                        IFactory iFactory = new AddFactory();
                        operation = iFactory.createOperation();
                        numAString = numString;
                        numString = numString.concat("+");
                    }
                }
                break;
            case R.id.btn_4:
                numString = numString.concat("4");
                break;
            case R.id.btn_5:
                numString = numString.concat("5");
                break;
            case R.id.btn_6:
                numString = numString.concat("6");
                break;
            case R.id.btn_minus:
                if (!TextUtils.isEmpty(numString)) {
                    if (!inputLimit) {
                        inputLimit = true;
                        IFactory iFactory = new MinusFactory();
                        operation = iFactory.createOperation();
                        numAString = numString;
                        numString = numString.concat("-");
                    }
                }
                break;
            case R.id.btn_1:
                numString = numString.concat("1");
                break;
            case R.id.btn_2:
                numString = numString.concat("2");
                break;
            case R.id.btn_3:
                numString = numString.concat("3");
                break;
            case R.id.btn_mul:
                if (!TextUtils.isEmpty(numString)) {
                    if (!inputLimit) {
                        inputLimit = true;
                        IFactory iFactory = new MulFactory();
                        operation = iFactory.createOperation();
                        numAString = numString;
                        numString = numString.concat("*");
                    }
                }
                break;
            case R.id.btn_point:
                if (!TextUtils.isEmpty(numString)) {
                    if (!numString.endsWith("+") &&
                            !numString.endsWith("-") &&
                            !numString.endsWith("*") &&
                            !numString.endsWith("/"))
                        numString = numString.concat(".");
                }
                break;
            case R.id.btn_0:
                numString = numString.concat("0");
                break;
            case R.id.btn_result:
                /**
                 * 获取最终结果，需要进行的操作:
                 * ①得到需要操作的两个数
                 * ②获取运算方法类
                 * ③设置数据
                 * ④获取结果
                 * ⑤设置UI显示
                 */
                if (!TextUtils.isEmpty(numString)) {
                    if (inputLimit && numString.length() > numAString.length() + 1) {
                        numBString = numString.substring(numAString.length() + 1);
                    }
                    if (inputLimit && operation != null) {
                        operation.setNumberA(Double.parseDouble(numAString));
                        operation.setNumberB(Double.parseDouble(numBString));
                        double result = operation.getResult();
                        numString = result + "";
                    }
                }
                break;
            case R.id.btn_div:
                if (!TextUtils.isEmpty(numString)) {
                    if (!inputLimit) {
                        inputLimit = true;
                        IFactory iFactory = new DivFactory();
                        operation = iFactory.createOperation();
                        numAString = numString;
                        numString = numString.concat("/");
                    }
                }
                break;
            case R.id.btn_clear:
                inputLimit = false;
                numString = "";
                numAString = "";
                etBlank.setText(null);
                break;
        }
        etBlank.setText(numString);
    }
}
