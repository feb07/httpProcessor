package com.feb.httpproject.httpProcessor;

/**
 * Created by lilichun on 2018/9/26.
 */
public interface ICallBack {
    void onSuccess(String response);
    void onFail(String e);
}
