package com.HeyGuo.android.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Author：YQZ
 * Time：  2017/8/1
 * Email： 17600116624@163.com
 * Content:
 */
public class fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity().getApplicationContext());
        textView.setText("我是fragment01");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(30);
        return textView;
    }
}
