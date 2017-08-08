package com.HeyGuo.android.ui.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.HeyGuo.android.R;
import com.HeyGuo.android.adapter.Adapter01;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.db.Tabs;
import com.HeyGuo.android.db.User;
import com.HeyGuo.android.mvp.view.MainActivityView;
import com.HeyGuo.android.utils.ToastManager;
import com.HeyGuo.android.widget.MyListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Mr.Yang
 * @time 2017/7/28 12:19
 * content:主界面   采用BaseActivity的统一头布局
 */
public class MainActivity extends BaseActivity implements Adapter01.Callback, View.OnClickListener, MainActivityView {
    View view;
    GridView gv;
    List<String> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    String[] titles1 = {"A1 号桌", "A2 号桌", "A3 号桌", "A4 号桌", "A5 号桌", "A6 号桌", "A7 号桌", "A8 号桌", "A9 号桌", "A10 号桌", "A11 号桌", "A12 号桌", "A13 号桌", "A14 号桌", "A15 号桌", "A16 号桌"};
    String[] titles2 = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相", "南公庄严照", "怀师法相", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};
    //记录点击的桌子的临时id
    private int tabsId;

    /**
     * @author Mr.Yang
     * @time 2017/8/5 13:54
     * content:修改屏幕的透明度
     * WindowManager.LayoutParams lp = getWindow().getAttributes();
     * //0.0-1.0
     * lp.alpha = (float) 0.5;
     * getWindow().setAttributes(lp);
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initFalseData() {
        //模拟数据
        for (int i = 0; i < titles1.length; i++) {
            list.add(titles1[i]);
        }
        for (int i = 0; i < titles2.length - 5; i++) {
            list2.add(titles2[i + 5]);
        }
    }

    @Override
    protected void initOtherEvent() {
        gv.setAdapter(new Adapter01(list, MainActivity.this, MainActivity.this));

    }

    @Override
    protected void initOtherView() {
        gv = (GridView) findViewById(R.id.gv_activity_tabs);
    }

    @Override
    public View addOtherView() {
        //往容器里面添加布局
        view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
        return view;
    }

    //设置是否点击两下退出
    @Override
    public boolean setControl() {
        return true;
    }

    //条目里面的按钮的点击事件，利用接口回调
    @Override
    public void click(View v) {
        switch (v.getId()) {
            //桌子的id
            case R.id.tabs_tv_id:
                //要知道是点的是那一张桌子，利用for循环，获取对应的id
//                for(int i = 0; i < list.size(); i ++){
//                    if(i == v.getTag()){
//                        User user = new User();
//                        user.setPassword("2");
//                        user.update(i);
//                    }
//                }
                switch ((int) v.getTag()) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
            //桌子的订单
            //显示订单
            case R.id.tabs_bt_tabsState:
                switch ((int) v.getTag()) {
                    case 0:
                        Intent intent = new Intent(this, OrderDataActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
            //用餐时间
            //显示点餐人数选择
            case R.id.tabs_tv_time:
                switch ((int) v.getTag()) {
                    case 0:
                        // Toast.makeText(getApplicationContext(),"我是第一张桌子",Toast.LENGTH_SHORT).show();
                        View tv = LayoutInflater.from(this).inflate(R.layout.activity_num_select_item01, null);
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setCustomTitle(tv);
                        View view = LayoutInflater.from(this).inflate(R.layout.activity_num_select_item02, null);
                        builder.setView(view);
                        builder.setCancelable(true);
                        builder.setPositiveButton("确认开桌", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();
                        break;
                }
                break;
            //用餐情况
            case R.id.tabs_tv_state:
                switch (v.getId()) {
                    case 0:

                        break;
                }
                //结账
            case R.id.tabs_bt_submit:
                switch ((int) v.getTag()) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, CheckOutActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
            //加菜
            case R.id.tabs_bt_add:
                switch ((int) v.getTag()) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, RetreatFoodActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
        }
    }

    //MainActivity里的点击事件
    @Override
    public void onClick(View v) {

    }
    @Override
    public String getTabsid() {
        return null;
    }

    @Override
    public String getTabstate() {
        return null;
    }

    @Override
    public String getTabnum() {
        return null;
    }

    @Override
    public String getTabtime() {
        return null;
    }

    //param : 1 开桌；2 关桌
    @Override
    public void showFailedError(int i) {
        if (i == 1) {
            //开桌失败的显示
            ToastManager.showToast(MainActivity.this, "开桌失败，请重新操作！", 1000);
        } else if (i == 2) {
            //关桌失败的显示
            ToastManager.showToast(MainActivity.this, "关桌失败，请重新操作！", 1000);
        }
    }
}

