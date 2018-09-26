package com.feb.httpproject;

import android.app.Application;

import com.feb.httpproject.httpProcessor.HttpHelper;
import com.feb.httpproject.httpProcessor.OkHttpProcessor;
import com.feb.httpproject.httpProcessor.VollyProcessor;

/**
 * Created by lilichun on 2018/9/26.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new VollyProcessor(this));
//        HttpHelper.init(new OkHttpProcessor());
    }
}
