package com.HeyGuo.android.db;

import org.litepal.crud.DataSupport;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:用户的数据模型
 * 店铺号storeid
 * 用户的name
 * 用户的password
 * 使用LitePal数据库，继承DataSupport
 */
public class User extends DataSupport{
    private String storeid;
    private String username ;
    private String password ;
    public String getStorenum() {
        return storeid;
    }
    public void setStorenum(String storeid) {
        this.storeid = storeid;
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
