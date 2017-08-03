package com.HeyGuo.android.mvp.model;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:
 */
public interface UserLoginIf {
    public void login(String username, String password, OnLoginListener loginListener);
}
