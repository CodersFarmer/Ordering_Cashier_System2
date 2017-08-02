package com.HeyGuo.android.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;

public class RetreatFoodActivity extends BaseActivity {
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initFalseData() {

    }

    @Override
    protected void initOtherEvent() {

    }

    @Override
    protected void initOtherView() {

    }

    @Override
    public View addOtherView() {
        view = LayoutInflater.from(RetreatFoodActivity.this).inflate(R.layout.activity_retreat_food,null);
        return view;
    }
}
