package com.HeyGuo.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.widget.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：YQZ
 * Time：  2017/8/5
 * Email： 17600116624@163.com
 * Content:订单数据的界面
 */
public class OrderDataActivity extends BaseActivity {
    private LayoutInflater mLayoutInflater;
    MyListView listView01;
    List<String> list03;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOrder();
    }
    private void initOrder() {
        list03 = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            list03.add("item" + i);
        }
        listView01 = (MyListView) findViewById(R.id.lv_parent);
        listView01.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list03.size();
            }
            @Override
            public Object getItem(int position) {
                return list03.get(position);
            }
            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder = null;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.lv_parent_item, null);
                    holder.listView03 = (MyListView) convertView.findViewById(R.id.lv_child);
                    holder.textView = (TextView) convertView.findViewById(R.id.tv_parent);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.textView.setText("fu" + position);
                holder.listView03.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return list03.size();
                    }
                    @Override
                    public Object getItem(int position) {
                        return list03.get(position);
                    }
                    @Override
                    public long getItemId(int position) {
                        return position;
                    }
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        ViewHolder02 holder02 = null;
                        if (convertView == null) {
                            holder02 = new ViewHolder02();
                            convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.lv_child_item, null);
                            holder02.textView01 = (TextView) convertView.findViewById(R.id.tv_header);
                            holder02.textView02 = (TextView) convertView.findViewById(R.id.tv_footer);
                            convertView.setTag(holder02);
                        } else {
                            holder02 = (ViewHolder02) convertView.getTag();
                        }
                        holder02.textView01.setText("tou" + position);
                        holder02.textView02.setText("jiao" + position);
                        return convertView;
                    }
                });
                return convertView;
            }
        });
    }
    //fu
    private static class ViewHolder {
        private MyListView listView03;
        private TextView textView;
    }
    //zi
    private static class ViewHolder02 {
        private TextView textView01;
        private TextView textView02;
    }

    @Override
    protected void initFalseData() {

    }

    @Override
    protected void initOtherEvent() {

    }

    @Override
    protected void initOtherView() {

    }

    @Override
    public View addOtherView() {
        mLayoutInflater = LayoutInflater.from(this);
        View view = mLayoutInflater.inflate(R.layout.activity_orderdata,null);
        return view;
    }

    @Override
    public boolean setControl() {
        return false;
    }
}
