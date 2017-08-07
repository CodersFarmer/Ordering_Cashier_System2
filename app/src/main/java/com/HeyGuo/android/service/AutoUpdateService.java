package com.HeyGuo.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

/**
 * Author：YQZ
 * Time：  2017/8/7
 * Email： 17600116624@163.com
 * Content:一个用于更新数据的服务，时间间隔是20s,主要是更新桌子的数据
 */
public class AutoUpdateService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        updateTabsData();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int time = 20 * 1000; //20s
        long triggerAtTime = SystemClock.elapsedRealtime() + time;
        Intent i = new Intent(this,AutoUpdateService.class);
        PendingIntent pi = PendingIntent.getService(this,0,i,0);
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME,triggerAtTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }
    /**
     * 更新桌子的数据
     * */
    private void updateTabsData(){

    }
}
