package com.example.week8.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

    static  OkHttpUtils okHttpUtils;
    OkHttpClient okHttpClient;
    //单例
    private OkHttpUtils(){
        okHttpClient=new OkHttpClient();
        okHttpClient.newBuilder().addInterceptor(new MyInterceptor()).build();
    }

    public  static  synchronized  OkHttpUtils getInstance(){
         if(okHttpUtils==null){
             okHttpUtils=new OkHttpUtils();
         }
        return  okHttpUtils;
    }

    //拦截器
    public  class MyInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.e("tag","Url="+request.method());
            Log.e("tag","Url="+request.url());
            Response response = chain.proceed(request);
            return response;
        }
    }

    public void doPost(String name, String pwd, String url, final Handler handler) {
        FormBody.Builder formbody=new FormBody.Builder();
        formbody.add("phone",name);
        formbody.add("pwd",pwd);
        RequestBody body=formbody.build();
        Request request=new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message =new Message() ;
                message.obj=json;
                message.arg1=1;
                handler.sendMessage(message);
            }
        });

    }

    public void doGet(String url, final Handler handler) {
        Request request=new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message =new Message() ;
                message.obj=json;
                message.arg1=2;
                handler.sendMessage(message);
            }
        });
    }

}
