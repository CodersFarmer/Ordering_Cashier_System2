package com.HeyGuo.android.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Yang
 * @time 2017/8/3 14:02
 * content:结账的界面
 */
public class CheckOutActivity extends BaseActivity implements View.OnClickListener {
    View view;
    Spinner spinner;
    Button button01;
    List<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;//创建一个数组适配器
    private LayoutInflater mLayoutinflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutinflater = LayoutInflater.from(CheckOutActivity.this);
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
                if (position == 3) {
                    View view01 = mLayoutinflater.inflate(R.layout.activity_check_out_item01, null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(CheckOutActivity.this);
                    builder.setCustomTitle(view01);
                    View view02 = mLayoutinflater.inflate(R.layout.activity_check_out_item02, null);
                    builder.setView(view02);
                    builder.setCancelable(true);
                    builder.setNegativeButton("确认抹零", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    protected void initOtherView() {
        spinner = (Spinner) findViewById(R.id.sp_activity_discount);
        button01 = (Button) findViewById(R.id.activity_check_out_confirm);
        button01.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        //请确认已结账，并且打印小票
        switch (v.getId()){
            case R.id.activity_check_out_confirm:
                View view03 = mLayoutinflater.inflate(R.layout.activity_check_out_item03, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(CheckOutActivity.this);
                builder.setCustomTitle(view03);
                builder.setCancelable(true);
                builder.setPositiveButton("好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
        }

    }


}
