package com.HeyGuo.android.mvp.model;

import com.HeyGuo.android.db.Food;
import com.HeyGuo.android.db.Tabs;
import com.HeyGuo.android.db.User;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:M层的接口的实现类，实现主页的开桌逻辑，还有一个开桌情况的监听
 * 登陆的网络耗时操作
 */
public class UserStartIm implements UserStartIf{
    @Override
    public void start(String tabsid,String tabsstate,String tabsnum,String tabstime, OnStartListener onStartListener) {


    }
}

