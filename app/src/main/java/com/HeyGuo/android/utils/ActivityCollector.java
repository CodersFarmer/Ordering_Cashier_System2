package com.HeyGuo.android.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mryang on 2017/6/12.
 * Email：
 * Content：activity的收集器，可以遍历关闭activity
 */

public class ActivityCollector {
    public static List<Activity> list = new ArrayList<>();

    //添加activity
    public static void addActivityS(Activity activity) {
        list.add(activity);
    }

    //移除activity
    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }
    //结束所有的activity
    public static void finishAll() {
        for (Activity activity : list) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
