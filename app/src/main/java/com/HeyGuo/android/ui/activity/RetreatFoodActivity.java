package com.HeyGuo.android.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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
 * content:退菜的界面
 */
public class RetreatFoodActivity extends BaseActivity implements ListViewAdapter02.Callback ,View.OnClickListener{
    View view;
    ListView myListView;
    List<String> list01 = new ArrayList<>();
    Button button01;
    Button button02;
    Button button03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
    }
    @Override
    protected void initOtherView() {
        myListView = (ListView) findViewById(R.id.mlv_retreatfood_data);
        button01 = (Button) findViewById(R.id.activity_retreat_food_back);
        button02 = (Button) findViewById(R.id.activity_retreat_food_correct);
        button03 = (Button) findViewById(R.id.activity_retreat_food_cancel);
    }
    @Override
    public View addOtherView() {
        view = LayoutInflater.from(RetreatFoodActivity.this).inflate(R.layout.activity_retreat_food, null);
        return view;
    }
    @Override
    public boolean setControl() {
        return false;
    }
    @Override
    public void click(View v) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_retreat_food_back:
                finish();
                break;
            case R.id.activity_retreat_food_correct:
                //TODO:退菜处理
                Intent intent = new Intent(RetreatFoodActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_retreat_food_cancel:
                finish();
                break;
        }
    }
}
