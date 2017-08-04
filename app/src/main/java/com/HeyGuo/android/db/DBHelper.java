package com.HeyGuo.android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Author：YQZ
 * Time：  2017/8/4
 * Email： 17600116624@163.com
 * Content:数据库表达的帮助类
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "User.db";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(Context context) {
        //CursorFactory设置为null,使用默认值
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //数据库第一次被创建时onCreate会被调用
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    //如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
