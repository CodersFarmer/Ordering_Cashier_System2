package com.HeyGuo.android.mvp.model;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:M层的接口，定义了对应的功能
 */
public interface UserStopIf {
    public void stop(String tabsid,String tabsstate,String tabsnum,String tabstime,OnStopListener onStopListener);
}
