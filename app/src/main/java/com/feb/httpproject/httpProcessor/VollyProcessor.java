package com.feb.httpproject.httpProcessor;


import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lilichun on 2018/9/26.
 */
public class VollyProcessor implements IHttpProcessor {

    private static RequestQueue requestQueue = null;

    public VollyProcessor(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, final Map<String, Object> params, final ICallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFail(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> rd = new HashMap<>();
                Gson gson = new Gson();
                rd.put("rd", gson.toJson(params));
                return rd;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void get(String url, final Map<String, Object> params, final ICallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFail(error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> rd = new HashMap<>();
                Gson gson = new Gson();
                rd.put("rd", gson.toJson(params));
                return rd;
            }
        };
        requestQueue.add(stringRequest);
    }
}
