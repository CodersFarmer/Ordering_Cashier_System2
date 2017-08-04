package com.HeyGuo.android.ui.activity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.HeyGuo.android.R;
import com.HeyGuo.android.adapter.ListViewAdapter02;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.widget.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Yang
 * @time 2017/8/3 14:02
 * content:退货的界面
 */
public class RetreatFoodActivity extends BaseActivity implements ListViewAdapter02.Callback {
    View view;
    ListView myListView;
    List<String> list01 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不实现点击两次退出界面
        BaseActivity.control = false;
    }

    @Override
    protected void initFalseData() {
        for (int i = 0; i < 30; i++) {
            list01.add("退菜" + i);
        }
    }

    @Override
    protected void initOtherEvent() {
        myListView.setAdapter(new ListViewAdapter02(list01, RetreatFoodActivity.this, RetreatFoodActivity.this));
    }

    @Override
    protected void initOtherView() {
        myListView = (ListView) findViewById(R.id.mlv_retreatfood_data);
    }

    @Override
    public View addOtherView() {
        view = LayoutInflater.from(RetreatFoodActivity.this).inflate(R.layout.activity_retreat_food, null);
        return view;
    }

    @Override
    public void click(View v) {

    }
}
