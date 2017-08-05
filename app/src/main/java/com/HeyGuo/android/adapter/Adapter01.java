package com.HeyGuo.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.HeyGuo.android.R;
import java.util.List;

/**
 * Author：YQZ
 * Time：  2017/8/1
 * Email： 17600116624@163.com
 * Content:首页桌数的CardView的适配器
 */
public class Adapter01 extends BaseAdapter implements View.OnClickListener {
    List<String> titles1;
    private LayoutInflater mInflater;
    private Callback mCallback;
    /**
     * 自定义接口，用于回调按钮点击事件到Activity
     *
     */
    public interface Callback {
        public void click(View v);
    }
    @Override
    public void onClick(View v) {
        mCallback.click(v);
    }
    public Adapter01(List<String> s, Context context, Callback callback) {
        this.titles1 = s;
        mInflater = LayoutInflater.from(context);
        this.mCallback = callback;
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
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.activity_tabs_item, null);
            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.tabs_tv_id);
            viewHolder.textView2 = (TextView) convertView.findViewById(R.id.tabs_tv_state);
            viewHolder.textView3 = (TextView) convertView.findViewById(R.id.tabs_tv_time);
            viewHolder.button1 = (Button) convertView.findViewById(R.id.tabs_bt_tabsState);
            viewHolder.button2 = (Button) convertView.findViewById(R.id.tabs_bt_add);
            viewHolder.button3 = (Button) convertView.findViewById(R.id.tabs_bt_submit);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(titles1.get(position));
        viewHolder.textView1.setOnClickListener(this);
        viewHolder.textView1.setTag(position);
        viewHolder.textView2.setText(titles1.get(position));
        viewHolder.textView2.setOnClickListener(this);
        viewHolder.textView2.setTag(position);
        viewHolder.textView3.setText(titles1.get(position));
        viewHolder.textView3.setOnClickListener(this);
        viewHolder.textView3.setTag(position);
        viewHolder.button1.setText(titles1.get(position));
        viewHolder.button1.setOnClickListener(this);
        viewHolder.button1.setTag(position);
        viewHolder.button2.setText(titles1.get(position));
        viewHolder.button2.setOnClickListener(this);
        viewHolder.button2.setTag(position);
        viewHolder.button3.setText(titles1.get(position));
        viewHolder.button3.setOnClickListener(this);
        viewHolder.button3.setTag(position);
        return convertView;
    }
    private static class ViewHolder {
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private Button button1;
        private Button button2;
        private Button button3;
    }
}

