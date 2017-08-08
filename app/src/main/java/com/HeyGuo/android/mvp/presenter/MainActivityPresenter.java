package com.HeyGuo.android.mvp.presenter;

import android.os.Handler;

import com.HeyGuo.android.db.Tabs;
import com.HeyGuo.android.db.User;
import com.HeyGuo.android.mvp.model.OnLoginListener;
import com.HeyGuo.android.mvp.model.OnStartListener;
import com.HeyGuo.android.mvp.model.OnStopListener;
import com.HeyGuo.android.mvp.model.UserLoginIm;
import com.HeyGuo.android.mvp.model.UserStartIm;
import com.HeyGuo.android.mvp.model.UserStopIm;
import com.HeyGuo.android.mvp.view.LoginActivityView;
import com.HeyGuo.android.mvp.view.MainActivityView;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:P层中间者，持有
 */
public class MainActivityPresenter {
    private UserStartIm userStartIm;
    private UserStopIm userStopIm;
    private MainActivityView mainActivityView;
    private Handler mHandler = new Handler();

    public MainActivityPresenter(MainActivityView mainActivityView) {
        this.userStartIm = new UserStartIm();
        this.userStopIm = new UserStopIm();
        this.mainActivityView = mainActivityView;
    }

    //开桌
    public void start() {
        userStartIm.start(mainActivityView.getTabsid(), mainActivityView.getTabstate(),
                mainActivityView.getTabnum(),
                mainActivityView.getTabtime(),
                new OnStartListener() {
                    @Override
                    public void startSuccess(Tabs tabs) {

                    }

                    @Override
                    public void startFailed() {

                    }
                });
    }

    //关桌
    public void stop() {
        userStopIm.stop(mainActivityView.getTabsid(),
                mainActivityView.getTabstate(),
                mainActivityView.getTabnum(),
                mainActivityView.getTabtime(),
                new OnStopListener() {
                    @Override
                    public void stopSuccess(Tabs tabs) {

                    }

                    @Override
                    public void stopFailed() {

                    }
                });
    }
}
