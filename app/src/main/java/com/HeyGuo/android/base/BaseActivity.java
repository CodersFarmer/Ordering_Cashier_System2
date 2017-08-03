package com.HeyGuo.android.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.HeyGuo.android.R;
import com.HeyGuo.android.utils.ActivityCollector;

/**
 * Author：YQZ
 * Time：  2017/7/31
 * Email： 17600116624@163.com
 * Content:有点击两次返回才退出界面,初始化屏幕方向，有默认的头布局
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    //退出时的时间
    private long mExitTime = 0;
    //初始屏幕的状态   默认是横屏
    private boolean state = true;
    //控制返回键功能的变量
    public static boolean control = true;
    //容器
    public static FrameLayout frameLayout;
    TextView cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化状态栏
        initStatus();
        setContentView(R.layout.activity_base);
        //初始化屏幕的方向  横屏
        initScreenOrientation(state);
        //控制activity
        ActivityCollector.addActivityS(this);
        //初始化头布局的按钮
        initView();
        //往容器里面加载其他子界面布局
        BaseActivity.frameLayout.addView(addOtherView());
        //初始其他子界面布局的按钮
        initOtherView();
        //初始化头布局按钮的点击事件
        initEvent();
        //加载模拟数据
        initFalseData();
        //初始其他子界面布局按钮的点击事件
        initOtherEvent();
    }

    protected abstract void initFalseData();

    //初始其他子界面布局按钮的点击事件
    protected abstract void initOtherEvent();

    //加载其他子界面布局
    protected abstract void initOtherView();

    //在容器里面加载子布局界面
    public abstract View addOtherView();

    private void initEvent() {
        cancel.setOnClickListener(this);
    }

    //初始化布局
    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.activity_base_container);
        cancel = (TextView) findViewById(R.id.tv_Baseactivity_cancel);

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
    //退出键
    public void exit(boolean b) {
        if (b) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(BaseActivity.this, "再按一次退出嘿果点餐管理系统！", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
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
    //点击事件
    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.tv_Baseactivity_cancel:
//                Toast.makeText(getApplicationContext(), "我是Base指令", Toast.LENGTH_SHORT).show();
//                break;
//        }
    }
}
