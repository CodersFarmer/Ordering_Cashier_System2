package com.HeyGuo.android.mvp.view;

import com.HeyGuo.android.db.User;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:V层的接口，主要是一些方法的回调
 */
public interface MainActivityView {
    String getTabsid();
    String getTabstate();
    String getTabnum();
    String getTabtime();
    void showFailedError(int i);
}
