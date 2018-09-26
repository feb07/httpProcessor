package com.feb.httpproject.httpProcessor;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by lilichun on 2018/9/26.
 */
public abstract class HttpCallBack<Result> implements ICallBack {

    @Override
    public void onSuccess(String response) {
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        Result result = (Result) gson.fromJson(response, clz);
        onSuccess(result);
    }

    public abstract void onSuccess(Result result);

    public static Class<?> analysisClassInfo(Object object) {
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) params[0];
    }
}
