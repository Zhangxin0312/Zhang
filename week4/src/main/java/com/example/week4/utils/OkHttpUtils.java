package com.example.week4.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.week4.m.MyModel;

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
    private  OkHttpUtils(){
             okHttpClient=new OkHttpClient();
             OkHttpClient.Builder builder=new OkHttpClient.Builder();
             builder.addInterceptor(new MyInterceptor());
             builder.build();
    }
    public  static  OkHttpUtils getInstance(){
        if(okHttpUtils==null){
            okHttpUtils=new OkHttpUtils();
        }
        return okHttpUtils;
    }




    public  class MyInterceptor implements Interceptor {
         @Override
         public Response intercept(Chain chain) throws IOException {
             Request request = chain.request();
             Log.e("tag","url="+request.url());
             Response response = chain.proceed(request);
             return response;
         }
     }

    public void doPost(String url, String phone, String pwd, final Handler handler, MyModel.MyCallBack myCallBack) {
        FormBody.Builder formbody=new FormBody.Builder();
        formbody.add("phone",phone);
        formbody.add("pwd",pwd);
        RequestBody body= formbody.build();
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
    public void doGet(String url, final Handler handler, MyModel.MyCallBack myCallBack) {
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
    public void doGets(String url, int id, final Handler handler, MyModel.MyCallBack myCallBack) {
        url=url+id;
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
                message.arg1=3;
                handler.sendMessage(message);
            }
        });
    }
}
