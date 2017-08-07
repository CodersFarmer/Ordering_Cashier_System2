package com.HeyGuo.android.ui.fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.HeyGuo.android.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：YQZ
 * Time：  2017/8/1
 * Email： 17600116624@163.com
 * Content:模拟的一种食物的信息界面
 * TODO：在构造方法里面,传递Food集合
 * Food集合的size就是TabLayout的适配器里Title的长度
 * 而对应一个Food对象里面的Type集合的长度就是cardview的适配器里面的长度。
 */
public class FoodFragment extends Fragment {
    GridView gridView;
    List<String> list01 = new ArrayList<>();
    List<Integer> list02 = new ArrayList<>();
    boolean state = true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(state){
        for (int i = 0; i < 10; i ++){
            list01.add("小苹果");
            list02.add(i);
        }
        state = false;
        }
        View view = inflater.inflate(R.layout.fragment_food,null);
        gridView = (GridView) view.findViewById(R.id.gv_fragment_food);
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list02.size();
            }

            @Override
            public Object getItem(int position) {
                return list02.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder;
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_food_item, null);
                    viewHolder.textView1 = (TextView) convertView.findViewById(R.id.tv_fragment_foodname);
                    viewHolder.textView2 = (TextView) convertView.findViewById(R.id.tv_fragment_now_foodnum);
                    viewHolder.textView3 = (TextView) convertView.findViewById(R.id.tv_fragment_show_foodnum);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.textView1.setText(list02.get(position)+"");
                viewHolder.textView2.setText(list02.get(position)+"");
                viewHolder.textView3.setText(list02.get(position)+"");
                return convertView;
            }
        });
        return view;
    }
    private static class ViewHolder {
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
    }
}
