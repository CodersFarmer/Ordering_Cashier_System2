package com.HeyGuo.android.mvp.presenter;

import com.HeyGuo.android.mvp.model.UserLodinIm;
import com.HeyGuo.android.mvp.model.UserLoginIf;
import com.HeyGuo.android.mvp.view.LoginActivityView;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:
 */
public class LoginActivityPresenter {
    private UserLoginIf userLoginIm;
    private LoginActivityView loginActivityView;
    public LoginActivityPresenter(LoginActivityView loginActivityViews){
        this.userLoginIm = new UserLodinIm();
        this.loginActivityView = loginActivityViews;
    }
}
