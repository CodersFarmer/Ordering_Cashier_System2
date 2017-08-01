package com.HeyGuo.android.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;
/**
*
*@author Mr.Yang
*@time 2017/8/1 14:07
*content:点餐界面
*/
public class SelectActivity extends BaseActivity {
    private LayoutInflater mInflater;
    TableLayout tableLayout;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不实现点击两次退出界面
        BaseActivity.control = false;
        mInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //填充内容
        view = mInflater.inflate(R.layout.activity_select,null);
        BaseActivity.frameLayout.addView(view);
        //
        tableLayout = (TableLayout) findViewById(R.id.tl_activity_food);
    }
}
