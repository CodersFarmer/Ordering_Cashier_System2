package com.HeyGuo.android.utils;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

/**
 * Author：YQZ
 * Time：  2017/8/7
 * Email： 17600116624@163.com
 * Content:一个可以修改Toast的管理类
 */
public class ToastManager {
    public static void showToast(final Activity activity, final String word, final long time){
        activity.runOnUiThread(new Runnable() {
            public void run() {
                final Toast toast = Toast.makeText(activity, word, Toast.LENGTH_LONG);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        toast.cancel();
                    }
                }, time);
            }
        });
    }
}
