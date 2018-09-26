package com.feb.httpproject.httpProcessor;

import java.util.Map;

/**
 * Created by lilichun on 2018/9/26.
 */
public interface IHttpProcessor {
    void post(String url, Map<String, Object> params, ICallBack callBack);

    void get(String url, Map<String, Object> params, ICallBack callBack);
}
