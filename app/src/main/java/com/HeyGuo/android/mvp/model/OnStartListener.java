package com.HeyGuo.android.mvp.model;

import com.HeyGuo.android.db.Tabs;
import com.HeyGuo.android.db.User;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:对开桌成功和失败的监听
 */
public interface OnStartListener {
    void startSuccess(Tabs tabs);
    void startFailed();
}
