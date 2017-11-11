package com.tongtong.designpatterndemo.patterns.decorator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.tongtong.designpatterndemo.R;

import java.util.ArrayList;

/**
 * 装饰选择器
 * Created by allen on 2017/11/11.
 */

public class GridAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<ItemBean> decoratorList;

    public GridAdapter(Context ctx, ArrayList<ItemBean> decoratorList) {
        this.ctx = ctx;
        this.decoratorList = decoratorList;
    }

    @Override
    public int getCount() {
        return decoratorList == null ? 0 : decoratorList.size();
    }

    @Override
    public Object getItem(int i) {
        return decoratorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(ctx).inflate(R.layout.item_checkbox, null);
            holder.cbDecorator = view.findViewById(R.id.cb_decorator);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        boolean checked = decoratorList.get(i).isChecked();
        if (checked) {
            holder.cbDecorator.setChecked(true);
        } else {
            holder.cbDecorator.setChecked(false);
        }
        holder.cbDecorator.setText(decoratorList.get(i).getText());
        //添加选中的监听
        holder.cbDecorator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (listener != null) listener.onSelected(i);
                } else {
                    if (listener != null) listener.onCanceled(i);
                }
            }
        });
        return view;
    }

    static class ViewHolder {
        CheckBox cbDecorator;
    }

    public void setIOnSelectedListener(IOnSelectedListener listener) {
        this.listener = listener;
    }

    private IOnSelectedListener listener;

    public interface IOnSelectedListener {
        void onSelected(int position);

        void onCanceled(int position);
    }


    public void updateGrid(ArrayList<ItemBean> decoratorList) {
        this.decoratorList = decoratorList;
        notifyDataSetChanged();
    }

}
