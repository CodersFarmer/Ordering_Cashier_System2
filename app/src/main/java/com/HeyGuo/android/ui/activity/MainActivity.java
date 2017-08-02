package com.HeyGuo.android.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.HeyGuo.android.R;
import com.HeyGuo.android.adapter.Adapter01;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.widget.HorizontalListView;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Mr.Yang
 * @time 2017/7/28 12:19
 * content:主界面   采用BaseActivity的统一头布局
 *TODO：利用接口回调，实现条目里面的按钮的点击事件
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener ,Adapter01.Callback{
    HorizontalListView horizontalListView1;
    HorizontalListView horizontalListView2;
    LinearLayout linearLayout1;
    View linearLayout2;
    View view;
    List<String> list = new ArrayList<>();
    String[] titles1 = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};
    String[] titles2 = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initFalseData() {
        //模拟数据
        for(int i = 0;i < titles1.length;i ++){
            list.add(titles1[i]);
        }
    }

    @Override
    protected void initOtherEvent() {
        horizontalListView1.setAdapter(new Adapter01(list,MainActivity.this,MainActivity.this));
        horizontalListView1.setOnItemClickListener(this);
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
                    convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_tabs_item, null);
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
    protected void initOtherView() {
        horizontalListView1 = (HorizontalListView) findViewById(R.id.hl_tab01);
        horizontalListView2 = (HorizontalListView) findViewById(R.id.hl_tab02);
        linearLayout1 = (LinearLayout) findViewById(R.id.ll_acticity_content);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll_activity_num_header);
    }

    @Override
    public View addOtherView() {
        //往容器里面添加布局
        view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main,null);
        return view;
    }

    //条目点击事件 跳转到订单详情界面
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    //条目里面的按钮的点击事件，利用接口回调
    @Override
    public void click(View v) {
        switch (v.getId()){
            case R.id.tabs_tv_id:
                switch ((int)v.getTag()){
                    case 0:
                       // Toast.makeText(getApplicationContext(),"我是第一张桌子",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                        startActivity(intent);
                        break;
                }
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


}

