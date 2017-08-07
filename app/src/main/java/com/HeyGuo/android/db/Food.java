package com.HeyGuo.android.db;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Author：YQZ
 * Time：  2017/8/5
 * Email： 17600116624@163.com
 * Content:食物的表
 * 依据种类来分
 * 一种里的一个又具有一个唯一的id；
 * 一个code：
 * 一个name；
 * 一个数量。
 */
public class Food extends DataSupport {
    private String type;
    private List<Type> typeList;
    public List<Type> getTypeList() {
        return typeList;
    }
    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }
    private class Type {
        private int code;
        private String name;
        private int amount;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
