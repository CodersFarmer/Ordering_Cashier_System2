package com.HeyGuo.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity2;
import com.HeyGuo.android.db.User;
import com.HeyGuo.android.mvp.presenter.LoginActivityPresenter;
import com.HeyGuo.android.mvp.view.LoginActivityView;

import org.litepal.crud.DataSupport;

/**
 * @author Mr.Yang
 * @time 2017/7/31 12:06
 * content:登陆界面    可以实现点击两次退出
 */
public class LoginActivity extends BaseActivity2 implements LoginActivityView {
    private LoginActivityPresenter loginActivityPresenter;
    public EditText et_storename;
    public EditText et_username;
    public EditText et_password;
    public TextView tv_onlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        //开启点击两次退出
        BaseActivity2.control = true;
        loginActivityPresenter = new LoginActivityPresenter(this);
    }
    public void initView() {
        et_storename = (EditText) findViewById(R.id.et_activity_storename);
        et_username = (EditText) findViewById(R.id.et_activity_username);
        et_password = (EditText) findViewById(R.id.et_activity_password);
        tv_onlogin = (TextView) findViewById(R.id.tv_activity_onlogin);
    }
    //登陆
    public void login(View view) {
        loginActivityPresenter.login();
    }
    @Override
    public String getStoreId() {
        String storeid = et_storename.getText().toString().trim();
        if (!TextUtils.isEmpty(storeid)) {
            return storeid;
        }else {
            Toast.makeText(this, "请检查您的店铺号，不能为空", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
    @Override
    public String getUserName() {
        String username = et_username.getText().toString().trim();
        if (!TextUtils.isEmpty(username)) {
            return username;
        }else {
            Toast.makeText(this, "请检查您的账号，不能为空", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
    @Override
    public String getPassword() {
        String password = et_password.getText().toString().trim();
        if (!TextUtils.isEmpty(password)) {
            return password;
        }else {
            Toast.makeText(this, "请检查您的密码，不能为空", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
    @Override
    public void showLoading() {
        tv_onlogin.setText("正在登陆......");
        tv_onlogin.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideLoading() {
        tv_onlogin.setVisibility(View.GONE);
    }
    @Override
    public void toMainActivity(User user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", user.getUsername());
        startActivity(intent);
        DataSupport.findAll(User.class);
    }
    @Override
    public void showFailedError() {
        Toast.makeText(this, "登陆失败，请检查您的账号和密码", Toast.LENGTH_SHORT).show();
    }
}
