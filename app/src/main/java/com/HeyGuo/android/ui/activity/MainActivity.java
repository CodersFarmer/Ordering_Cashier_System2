package com.HeyGuo.android.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.HeyGuo.android.R;
import com.HeyGuo.android.adapter.Adapter01;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.widget.HorizontalListView;
import com.HeyGuo.android.widget.MyListView;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Mr.Yang
 * @time 2017/7/28 12:19
 * content:主界面   采用BaseActivity的统一头布局
 * TODO：订餐布局的处理
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener, Adapter01.Callback, View.OnClickListener {
    HorizontalListView horizontalListView1;
    HorizontalListView horizontalListView2;
    LinearLayout linearLayout1;
    View linearLayout2;
    View linearLayout3;
    View view;
    GridView gv;
    Button bt_num_can;
    List<String> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    String[] titles1 = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};
    String[] titles2 = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};
    MyListView listView01;
    List<String> list03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseActivity.control = true;
        initOrder();

    }
    private void initOrder() {
        list03 = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
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
                    convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.lv_parent_item, null);
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
                            convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.lv_child_item, null);
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
    @Override
    protected void initFalseData() {
        //模拟数据
        for (int i = 0; i < titles1.length; i++) {
            list.add(titles1[i]);
        }
        for (int i = 0; i < titles2.length - 5; i++) {
            list2.add(titles2[i + 5]);
        }
    }
    @Override
    protected void initOtherEvent() {
        horizontalListView1.setAdapter(new Adapter01(list, MainActivity.this, MainActivity.this));
        horizontalListView1.setOnItemClickListener(this);
        horizontalListView2.setAdapter(new Adapter01(list2, MainActivity.this, MainActivity.this));
        gv.setAdapter(new Adapter01(list, MainActivity.this, MainActivity.this));
        bt_num_can.setOnClickListener(this);
    }
    @Override
    protected void initOtherView() {
        horizontalListView1 = (HorizontalListView) findViewById(R.id.hl_tab01);
        horizontalListView2 = (HorizontalListView) findViewById(R.id.hl_tab02);
        linearLayout1 = (LinearLayout) findViewById(R.id.ll_acticity_content);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll_activity_num_header);
        linearLayout3 = (LinearLayout) findViewById(R.id.ll_activity_order_data);
        gv = (GridView) findViewById(R.id.gv_activity_tabs);
        bt_num_can = (Button) findViewById(R.id.bt_num_cancel);
    }
    @Override
    public View addOtherView() {
        //往容器里面添加布局
        view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
        return view;
    }
    //条目点击事件 跳转到订单详情界面
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    //条目里面的按钮的点击事件，利用接口回调
    @Override
    public void click(View v) {
        switch (v.getId()) {
            case R.id.tabs_tv_id:
                switch ((int) v.getTag()) {
                    case 0:
                        // Toast.makeText(getApplicationContext(),"我是第一张桌子",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
            //显示订单
            case R.id.tabs_bt_tabsState:
                switch ((int) v.getTag()) {
                    case 0:
                        // Toast.makeText(getApplicationContext(),"我是第一张桌子",Toast.LENGTH_SHORT).show();
                        linearLayout1.setVisibility(View.GONE);
                        linearLayout2.setVisibility(View.GONE);
                        linearLayout3.setVisibility(View.VISIBLE);

                        break;
                }
                break;
            //显示点餐人数选择
            case R.id.tabs_tv_time:
                switch ((int) v.getTag()) {
                    case 0:
                        // Toast.makeText(getApplicationContext(),"我是第一张桌子",Toast.LENGTH_SHORT).show();
                        linearLayout1.setVisibility(View.GONE);
                        linearLayout3.setVisibility(View.GONE);
                        linearLayout2.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            //显示退菜界面
            case R.id.tabs_bt_submit:
                switch ((int) v.getTag()) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, RetreatFoodActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
            //显示结账界面
            case R.id.tabs_bt_add:
                switch ((int) v.getTag()) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, CheckOutActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_num_cancel:
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout3.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                break;
            case R.id.tv_Baseactivity_cancel:
                Toast.makeText(getApplicationContext(), "我是Base指令", Toast.LENGTH_SHORT).show();
                break;
        }
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

