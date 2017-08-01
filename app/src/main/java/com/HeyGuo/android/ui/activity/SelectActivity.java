package com.HeyGuo.android.ui.activity;


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.HeyGuo.android.R;
import com.HeyGuo.android.base.BaseActivity;
import com.HeyGuo.android.ui.fragment.fragment1;
import com.HeyGuo.android.ui.fragment.fragment2;
import com.HeyGuo.android.ui.fragment.fragment3;
import java.util.ArrayList;
import java.util.List;

/**
*
*@author Mr.Yang
*@time 2017/8/1 14:07
*content:点餐界面
*/
public class SelectActivity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    View view;
    Fragment fragment01;
    Fragment fragment02;
    Fragment fragment03;
    List<Fragment> list01;
    List<String> list02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不实现点击两次退出界面
        BaseActivity.control = true;
        //mInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //填充内容
        view = LayoutInflater.from(SelectActivity.this).inflate(R.layout.activity_select,null);
        BaseActivity.frameLayout.addView(view);
        //
        tabLayout = (TabLayout) findViewById(R.id.tl_activity_food);
        viewPager = (ViewPager) findViewById(R.id.vp_activity_food);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        fragment01 = new fragment1();
        fragment02 = new fragment2();
        fragment03 = new fragment3();
        list01 = new ArrayList<>();
        list02 = new ArrayList<>();
        list01.add(fragment01);
        list01.add(fragment02);
        list01.add(fragment03);
        list02.add("01");
        list02.add("02");
        list02.add("03");
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return list01.get(position);
            }

            @Override
            public int getCount() {
                return list01.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Page"+list02.get(position);
            }
        });
    }
}
