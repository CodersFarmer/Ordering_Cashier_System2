package com.HeyGuo.android.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.HeyGuo.android.R;
import com.HeyGuo.android.utils.ActivityCollector;

/**
 * Author：YQZ
 * Time：  2017/7/31
 * Email： 17600116624@163.com
 * Content:可以实现或取消点击两次返回才退出界面,初始化屏幕方向,没有默认的头布局
 */
public abstract class BaseActivity2 extends AppCompatActivity {
    //退出时的时间
    private long mExitTime = 0;
    //初始屏幕的状态   默认是横屏
    private boolean state = true;
    //控制返回键功能的变量
    public static boolean control = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化状态栏
        initStatus();
        //初始化屏幕的方向  横屏
        initScreenOrientation(state);
        //控制activity
        ActivityCollector.addActivityS(this);
    }
    //初始化屏幕的方向
    private void initScreenOrientation(boolean state) {
        //获取设备当前方向
        //int currentScreenOrientation = getResources().getConfiguration().orientation;
        if (state) {
            //横屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            //竖屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        }
    }
    private void initStatus() {
        //android系统为5.0及以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }
    //实现点击两次返回键退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit(control);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //退出
    public void exit(boolean b) {
        if (b) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //Toast.makeText(BaseActivity2.this, "再按一次退出嘿果点餐管理系统！", Toast.LENGTH_SHORT).show();
                showToast(BaseActivity2.this, "再按一次退出嘿果点餐管理系统！", 1000);
                mExitTime = System.currentTimeMillis();
            } else {
                ActivityCollector.finishAll();
            }
        } else {
            finish();
        }
    }
    //销毁时，清除集合
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
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
