package com.HeyGuo.android.mvp.model;

import com.HeyGuo.android.db.User;

/**
 * Author：YQZ
 * Time：  2017/8/3
 * Email： 17600116624@163.com
 * Content:M层的接口的实现类，实现具体的登陆逻辑，还有一个登陆情况的监听
 * 登陆的网络耗时操作
 */
public class UserLoginIm implements UserLoginIf {
    @Override
    public void login(final String username, final String password, final String storeid, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run()
            {
                //进行登陆请求
                //成功 开始计时，刷新餐桌数据；
                //往数据库存用户、食物、餐桌、订单的数据
                //失败，提示，重新登陆
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if ("admin".equals(username) && "admin".equals(password) && "1".equals(storeid)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setStorenum(storeid);
                    loginListener.loginSuccess(user);
                } else
                    {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}

