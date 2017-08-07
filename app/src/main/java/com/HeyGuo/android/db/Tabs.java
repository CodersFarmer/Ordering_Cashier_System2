package com.HeyGuo.android.db;

import org.litepal.crud.DataSupport;

/**
 * Author：YQZ
 * Time：  2017/8/5
 * Email： 17600116624@163.com
 * Content:用来记录餐桌信息的表
 */
public class Tabs extends DataSupport {
    private String id;
    private int state;
    private int num;
    private int price;
    private long time;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
