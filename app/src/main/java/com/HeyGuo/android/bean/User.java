package com.HeyGuo.android.bean;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:用户的数据模型
 * 店铺号
 * 用户的name
 * 用户的password
 */
public class User {
    private String storenum;
    private String username ;
    private String password ;
    public String getStorenum() {
        return storenum;
    }
    public void setStorenum(String storenum) {
        this.storenum = storenum;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
