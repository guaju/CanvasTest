package com.guaju.canvastest;

import android.app.Application;

/**
 * Created by guaju on 2018/5/8.
 */

public class MyApplication extends Application {
    static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
    public static MyApplication getApp(){
        return app;
    }
}
