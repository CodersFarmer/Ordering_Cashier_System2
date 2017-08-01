package com.HeyGuo.android.ui.activity;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.widget.HorizontalListView;


/**
 * @author Mr.Yang
 * @time 2017/7/28 12:19
 * content:主界面   采用BaseActivity的统一头布局
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    HorizontalListView horizontalListView1;
    HorizontalListView horizontalListView2;
    private LayoutInflater mInflater;
    LinearLayout linearLayout1;
    View linearLayout2;
    Button button1;
    View view;
    String[] titles1 = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};
    String[] titles2 = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //往容器里面添加布局
        view = mInflater.inflate(R.layout.activity_main,null);
        BaseActivity.frameLayout.addView(view);

        horizontalListView1 = (HorizontalListView) findViewById(R.id.hl_tab01);
        horizontalListView2 = (HorizontalListView) findViewById(R.id.hl_tab02);
        linearLayout1 = (LinearLayout) findViewById(R.id.ll_acticity_content);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll_activity_num_header);
        button1 = (Button) findViewById(R.id.bt_num_cancel);
        button1.setOnClickListener(this);
        horizontalListView1.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return titles1.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
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
                viewHolder.textView1.setText(titles1[position]);
                viewHolder.textView2.setText(titles1[position]);
                viewHolder.textView3.setText(titles1[position]);
                viewHolder.button1.setText(titles2[position]);
                viewHolder.button2.setText(titles2[position]);
                viewHolder.button3.setText(titles2[position]);
                return convertView;
            }
        });
        horizontalListView2.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return titles1.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
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
                viewHolder.textView1.setText(titles1[position]);
                viewHolder.textView2.setText(titles1[position]);
                viewHolder.textView3.setText(titles1[position]);
                viewHolder.button1.setText(titles2[position]);
                viewHolder.button2.setText(titles2[position]);
                viewHolder.button3.setText(titles2[position]);
                return convertView;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_num_cancel:
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.GONE);
                break;

        }
    }

    private static class ViewHolder {
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private Button button1;
        private Button button2;
        private Button button3;
    }
    public void cancel(View view){
        linearLayout1.setVisibility(View.GONE);
        linearLayout2.setVisibility(View.VISIBLE);
    }

}

