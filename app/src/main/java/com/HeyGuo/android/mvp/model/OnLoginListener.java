package com.HeyGuo.android.mvp.model;

import com.HeyGuo.android.bean.User;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
