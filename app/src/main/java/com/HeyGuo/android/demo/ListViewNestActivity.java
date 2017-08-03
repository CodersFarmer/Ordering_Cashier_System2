package com.HeyGuo.android.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.HeyGuo.android.R;
import com.HeyGuo.android.widget.MyListView;
import java.util.ArrayList;
import java.util.List;
/**
*
*@author Mr.Yang
*@time 2017/8/3 11:47
*content:解决了listView的双重嵌套问题
*/
public class ListViewNestActivity extends AppCompatActivity {
    MyListView listView01;
    List<String> list03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_nest);
        list03 = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
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
                    convertView = LayoutInflater.from(ListViewNestActivity.this).inflate(R.layout.lv_parent_item, null);
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
                            convertView = LayoutInflater.from(ListViewNestActivity.this).inflate(R.layout.lv_child_item, null);
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
}
