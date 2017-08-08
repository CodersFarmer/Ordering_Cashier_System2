package com.HeyGuo.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Author：YQZ
 * Time：  2017/8/8
 * Email： 17600116624@163.com
 * Content:点击选择菜品的适配器
 */
public class SelectFoodAdapter extends BaseAdapter implements View.OnClickListener{
    private LayoutInflater mLayoutinflater;
    private Context context;
    private List<String> list;
    private Callback callback;
    public SelectFoodAdapter(List<String> list,Context context,Callback callback){
        this.list = list;
        mLayoutinflater = LayoutInflater.from(context);
        this.callback = callback;
    }
    public interface Callback {
        public void click(View v);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
    private static class ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
    }
}
