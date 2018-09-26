package com.feb.httpproject.httpProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lilichun on 2018/9/26.
 */
public class HttpHelper implements IHttpProcessor {
    private static IHttpProcessor mhttpProcessor = null;
    private static HttpHelper _instance;
    private Map<String, Object> params;

    private HttpHelper() {
        params = new HashMap<>();
    }

    public static HttpHelper getInstance() {
        synchronized (HttpHelper.class) {
            if (_instance == null) {
                _instance = new HttpHelper();
            }
        }
        return _instance;
    }

    public static void init(IHttpProcessor httpProcessor) {
        mhttpProcessor = httpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        mhttpProcessor.post(url, params, callBack);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        mhttpProcessor.get(url, params, callBack);
    }

    public static String appendParams(String url, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }
        return url;
    }
}
