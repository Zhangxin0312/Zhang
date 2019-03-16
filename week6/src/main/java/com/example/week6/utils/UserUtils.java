package com.example.week6.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserUtils {
    static  UserUtils userUtils;
    OkHttpClient okHttpClient;
    //单例
    private  UserUtils(){
      okHttpClient=new OkHttpClient();
         okHttpClient.newBuilder().addInterceptor(new MyInterceptor()).build();
    }
    public static  synchronized  UserUtils getInstance(){
        if(userUtils==null){
            userUtils=new UserUtils();
        }
        return userUtils;
    }
    public  void doPost(String name, String pwd, final Handler handler){
        FormBody.Builder formbody=new FormBody.Builder();
        formbody.add("phone",name);
        formbody.add("pwd",pwd);
        RequestBody body=formbody.build();
        Request request=new Request.Builder()
                .post(body)
                .url("http://172.17.8.100/small/user/v1/register")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                //解析
                try {
                    JSONObject object= new JSONObject(json);
                     String msg= object.getString("message");
                    Message message =new Message() ;
                    message.obj=msg;
                     message.arg1=1;
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void doPosts(String name, String pwd, final Handler handler) {
        FormBody.Builder formbody=new FormBody.Builder();
        formbody.add("phone",name);
        formbody.add("pwd",pwd);
        RequestBody body=formbody.build();
        Request request=new Request.Builder()
                .post(body)
                .url("http://172.17.8.100/small/user/v1/login")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                //解析
                try {
                    JSONObject object= new JSONObject(json);
                    String msg= object.getString("message");
                    Message message =new Message() ;
                    message.obj=msg;
                    message.arg1=2;
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
                message.arg1=3;
                handler.sendMessage(message);
            }
        });
    }
    public  class MyInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            return response;
        }
    }
}
