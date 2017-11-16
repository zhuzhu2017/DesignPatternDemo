package com.tongtong.designpatterndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tongtong.designpatterndemo.patterns.decorator.DecoratorActivity;
import com.tongtong.designpatterndemo.patterns.factory.FactoryActivity;
import com.tongtong.designpatterndemo.patterns.prototype.PrototypeActivity;
import com.tongtong.designpatterndemo.patterns.proxy.ProxyActivity;
import com.tongtong.designpatterndemo.patterns.simplefactory.SimpleFactoryActivity;
import com.tongtong.designpatterndemo.patterns.strategy.StrategyActivity;
import com.tongtong.designpatterndemo.patterns.template.TemplateActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_mode_simple_factory)
    Button btnModeSimpleFactory;
    @BindView(R.id.btn_mode_strategy)
    Button btnModeStrategy;
    @BindView(R.id.btn_mode_decorate)
    Button btnModeDecorate;
    @BindView(R.id.btn_mode_proxy)
    Button btnModeProxy;
    @BindView(R.id.btn_mode_factory)
    Button btnModeFactory;
    @BindView(R.id.btn_mode_prototype)
    Button btnModePrototype;
    @BindView(R.id.btn_mode_template)
    Button btnModeTemplate;
    @BindView(R.id.btn_mode_appearance)
    Button btnModeAppearance;
    @BindView(R.id.btn_mode_builder)
    Button btnModeBuilder;
    @BindView(R.id.btn_mode_observer)
    Button btnModeObserver;
    @BindView(R.id.btn_mode_abstract_factory)
    Button btnModeAbstractFactory;
    @BindView(R.id.btn_mode_state)
    Button btnModeState;
    @BindView(R.id.btn_mode_adapter)
    Button btnModeAdapter;
    @BindView(R.id.btn_mode_memo)
    Button btnModeMemo;
    @BindView(R.id.btn_mode_portfolio)
    Button btnModePortfolio;
    @BindView(R.id.btn_mode_iterator)
    Button btnModeIterator;
    @BindView(R.id.btn_mode_single_instance)
    Button btnModeSingleInstance;
    @BindView(R.id.btn_mode_bridge)
    Button btnModeBridge;
    @BindView(R.id.btn_mode_order)
    Button btnModeOrder;
    @BindView(R.id.btn_mode_liability_chain)
    Button btnModeLiabilityChain;
    @BindView(R.id.btn_mode_broker)
    Button btnModeBroker;
    @BindView(R.id.btn_mode_flyweight)
    Button btnModeFlyweight;
    @BindView(R.id.btn_mode_interpreter)
    Button btnModeInterpreter;
    @BindView(R.id.btn_mode_visitor)
    Button btnModeVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_mode_simple_factory, R.id.btn_mode_strategy, R.id.btn_mode_decorate, R.id.btn_mode_proxy, R.id.btn_mode_factory, R.id.btn_mode_prototype, R.id.btn_mode_template, R.id.btn_mode_appearance, R.id.btn_mode_builder, R.id.btn_mode_observer, R.id.btn_mode_abstract_factory, R.id.btn_mode_state, R.id.btn_mode_adapter, R.id.btn_mode_memo, R.id.btn_mode_portfolio, R.id.btn_mode_iterator, R.id.btn_mode_single_instance, R.id.btn_mode_bridge, R.id.btn_mode_order, R.id.btn_mode_liability_chain, R.id.btn_mode_broker, R.id.btn_mode_flyweight, R.id.btn_mode_interpreter, R.id.btn_mode_visitor})
    public void onViewClicked(View view) {
        Intent jumpIntent = null;
        switch (view.getId()) {
            case R.id.btn_mode_simple_factory:  //简单工厂模式
                jumpIntent = new Intent(this, SimpleFactoryActivity.class);
                break;
            case R.id.btn_mode_strategy:    //策略模式
                jumpIntent = new Intent(this, StrategyActivity.class);
                break;
            case R.id.btn_mode_decorate:    //装饰模式
                jumpIntent = new Intent(this, DecoratorActivity.class);
                break;
            case R.id.btn_mode_proxy:   //代理模式
                jumpIntent = new Intent(this, ProxyActivity.class);
                break;
            case R.id.btn_mode_factory: //工厂方法模式
                jumpIntent = new Intent(this, FactoryActivity.class);
                break;
            case R.id.btn_mode_prototype:   //原型模式
                jumpIntent = new Intent(this, PrototypeActivity.class);
                break;
            case R.id.btn_mode_template:    //模板方法模式
                jumpIntent = new Intent(this, TemplateActivity.class);
                break;
            case R.id.btn_mode_appearance:  //外观模式
                break;
            case R.id.btn_mode_builder: //建造者模式
                break;
            case R.id.btn_mode_observer:    //观察者模式
                break;
            case R.id.btn_mode_abstract_factory:    //抽象工厂模式
                break;
            case R.id.btn_mode_state:   //状态模式
                break;
            case R.id.btn_mode_adapter: //适配器模式
                break;
            case R.id.btn_mode_memo:    //备忘录模式
                break;
            case R.id.btn_mode_portfolio:   //组合模式
                break;
            case R.id.btn_mode_iterator:    //迭代器模式
                break;
            case R.id.btn_mode_single_instance: //单例模式
                break;
            case R.id.btn_mode_bridge:  //桥接模式
                break;
            case R.id.btn_mode_order:   //命令模式
                break;
            case R.id.btn_mode_liability_chain: //职责链模式
                break;
            case R.id.btn_mode_broker:  //中介者模式
                break;
            case R.id.btn_mode_flyweight:   //享元模式
                break;
            case R.id.btn_mode_interpreter: //解释器模式
                break;
            case R.id.btn_mode_visitor: //访问者模式
                break;
        }
        if (jumpIntent != null) startActivity(jumpIntent);
    }
}
