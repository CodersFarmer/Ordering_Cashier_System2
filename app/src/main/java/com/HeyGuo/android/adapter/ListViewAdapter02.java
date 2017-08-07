package com.HeyGuo.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.HeyGuo.android.R;

import java.util.List;

/**
 * Author：YQZ
 * Time：  2017/8/2
 * Email： 17600116624@163.com
 * Content:
 * 添加食物的适配器
 * 退菜的适配器，也一样
 * 实现接口回调，处理条目里的按钮的点击事件
 */
public class ListViewAdapter02 extends BaseAdapter implements View.OnClickListener{
    List<String> titles1;
    private LayoutInflater mInflater;
    private Callback mCallback;
    public ListViewAdapter02(List<String> s, Context context, Callback callback) {
        this.titles1 = s;
        mInflater = LayoutInflater.from(context);
        this.mCallback = callback;
    }

    @Override
    public void onClick(View v) {
        mCallback.click(v);
    }

    public interface Callback {
        public void click(View v);
    }
    @Override
    public int getCount() {
        return titles1.size();
    }

    @Override
    public Object getItem(int position) {
        return titles1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.activity_food_select_item,null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.food_tv_id);
            holder.textView2 = (TextView) convertView.findViewById(R.id.food_tv_name);
            holder.textView3 = (TextView) convertView.findViewById(R.id.food_tv_num);
            holder.imageView01 = (ImageView) convertView.findViewById(R.id.food_iv_num_add);
            holder.imageView02 = (ImageView) convertView.findViewById(R.id.food_iv_num_reduce);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(titles1.get(position));
        holder.textView2.setText(titles1.get(position));
        holder.textView2.setOnClickListener(this);
        holder.textView2.setTag(position);
        holder.textView3.setText(titles1.get(position));
        return convertView;
    }
    private static class ViewHolder {
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private ImageView imageView01;
        private ImageView imageView02;
    }
}
