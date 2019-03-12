package com.bw.application;

import android.app.Application;

public abstract class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public abstract void init();
}
