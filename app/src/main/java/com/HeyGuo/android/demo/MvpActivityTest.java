package com.HeyGuo.android.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.HeyGuo.android.R;
import com.HeyGuo.android.bean.User;
import com.HeyGuo.android.mvp.presenter.LoginActivityPresenter;
import com.HeyGuo.android.mvp.view.LoginActivityView;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:使用接口回调，实现MVP的架构模式
 */
public class MvpActivityTest extends AppCompatActivity implements LoginActivityView{
    LoginActivityPresenter loginActivityPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_test);
        init();
    }

    private void init() {
        loginActivityPresenter = new LoginActivityPresenter(this);
    }

    @Override
    public String getStoreId() {
        return null;
    }

    @Override
    public String getUserName() {

        return null;
    }

    @Override
    public String getPassword() {

        return null;
    }
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedError() {

    }
}
