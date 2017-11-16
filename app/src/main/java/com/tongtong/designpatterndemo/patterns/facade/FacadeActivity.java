package com.tongtong.designpatterndemo.patterns.facade;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tongtong.designpatterndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 外观模式：
 * 为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，
 * 这个接口使得这一子系统更加容易使用
 * Created by allen on 2017/11/16.
 */

public class FacadeActivity extends AppCompatActivity {
    @BindView(R.id.btn_straight_buy)
    Button btnStraightBuy;
    @BindView(R.id.btn_buy_fund)
    Button btnBuyFund;
    @BindView(R.id.tv_buy_result)
    TextView tvBuyResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facade);
        ButterKnife.bind(this);
        setTitle("外观模式（客户直接买股票和买基金）");
    }

    @OnClick({R.id.btn_straight_buy, R.id.btn_buy_fund})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_straight_buy:
                StockA stockA = new StockA();
                StockB stockB = new StockB();
                StockC stockC = new StockC();
                String buyA = stockA.buy();
                String buyB = stockB.buy();
                String buyC = stockC.buy();
                String sellA = stockA.sell();
                String sellB = stockB.sell();
                String sellC = stockC.sell();
                tvBuyResult.setText(buyA + "," + buyB + "," + buyC + "\n" + sellA + "," + sellB + "." + sellC);
                break;
            case R.id.btn_buy_fund:
                Facade facade = new Facade();
                String buyFacade = facade.buy();
                String sellFacade = facade.sell();
                tvBuyResult.setText(buyFacade + "\n" + sellFacade);
                break;
        }
    }
}
