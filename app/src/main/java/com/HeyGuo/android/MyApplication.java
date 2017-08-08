package com.HeyGuo.android;
import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Author：YQZ
 * Time：  2017/7/28
 * Email： 17600116624@163.com
 * Content:自定义的Application，用于对部分数据的初始化
 *
 */
public class MyApplication extends Application {
    private Context context;
    private void getContext(){
        this.context = getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化LitePalApplication
        LitePalApplication.initialize(this);
    }
}
