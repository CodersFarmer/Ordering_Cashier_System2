package com.HeyGuo.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.base.BaseActivity2;

/**
*
*@author Mr.Yang
*@time 2017/7/31 12:06
*content:登陆界面    可以实现点击两次退出
*/
public class LoginActivity extends BaseActivity2 implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginActivity.control = true;
    }
    //登陆
    public void login(View view){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
