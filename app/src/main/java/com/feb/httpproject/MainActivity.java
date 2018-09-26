package com.feb.httpproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.feb.httpproject.httpProcessor.HttpCallBack;
import com.feb.httpproject.httpProcessor.HttpHelper;
import com.feb.httpproject.httpProcessor.VollyProcessor;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void requestData() {
        HttpHelper.getInstance().post("http://baidu.com", new HashMap<String, Object>(), new HttpCallBack<UserInfo>() {
            @Override
            public void onFail(String e) {

            }

            @Override
            public void onSuccess(UserInfo userInfo) {

            }
        });
    }
}
