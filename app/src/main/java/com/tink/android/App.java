package com.tink.android;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by Ervin on 2018/4/14.
 */

public class App extends Application {

    private static App mInstance;

    public static App getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
