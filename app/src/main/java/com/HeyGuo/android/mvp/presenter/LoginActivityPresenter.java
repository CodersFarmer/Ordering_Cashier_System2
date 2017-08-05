package com.HeyGuo.android.mvp.presenter;

import android.os.Handler;

import com.HeyGuo.android.db.User;
import com.HeyGuo.android.mvp.model.OnLoginListener;
import com.HeyGuo.android.mvp.model.UserLoginIm;
import com.HeyGuo.android.mvp.view.LoginActivityView;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:P层中间者，持有
 */
public class LoginActivityPresenter {
    private UserLoginIm userLoginIm;
    private LoginActivityView loginActivityView;
    private Handler mHandler = new Handler();

    public LoginActivityPresenter(LoginActivityView loginActivityViews) {
        this.userLoginIm = new UserLoginIm();
        this.loginActivityView = loginActivityViews;
    }

    //登陆
    public void login() {
        loginActivityView.showLoading();
        userLoginIm.login(loginActivityView.getUserName(), loginActivityView.getPassword(), loginActivityView.getStoreId(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginActivityView.toMainActivity(user);
                        loginActivityView.hideLoading();
                    }
                });
            }
            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginActivityView.showFailedError();
                        loginActivityView.hideLoading();
                    }
                });
            }
        });
    }
}
