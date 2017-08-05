package com.HeyGuo.android.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
/**
*
*@author Mr.Yang
*@time 2017/8/3 14:02
*content:结账的界面
*/
public class CheckOutActivity extends BaseActivity {
    View view;
    Spinner spinner;
    List<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;//创建一个数组适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initFalseData() {
        for (int i = 0; i < 7; i++) {
            list.add("我是折扣！" + i);
        }
    }

    @Override
    protected void initOtherEvent() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //为适配器设置下拉的样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CheckOutActivity.this,adapter.getItem(position)+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void initOtherView() {
        spinner = (Spinner) findViewById(R.id.sp_activity_discount);

    }

    @Override
    public View addOtherView() {
        view = LayoutInflater.from(CheckOutActivity.this).inflate(R.layout.activity_check_out, null);
        return view;
    }

    @Override
    public boolean setControl() {
        return false;
    }
}
