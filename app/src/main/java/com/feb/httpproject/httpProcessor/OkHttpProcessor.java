package com.feb.httpproject.httpProcessor;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lilichun on 2018/9/26.
 */
public class OkHttpProcessor implements IHttpProcessor {

    private OkHttpClient client;

    public OkHttpProcessor() {
        client = new OkHttpClient();
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("rd", new Gson().toJson(params));
        Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                callBack.onSuccess(response.body().string());
            } else {
                callBack.onFail(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                callBack.onSuccess(response.body().string());
            } else {
                callBack.onFail(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
