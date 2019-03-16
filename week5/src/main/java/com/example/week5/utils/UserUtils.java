package com.example.week5.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserUtils {


     static   UserUtils userUtils;
     OkHttpClient okHttpClient;
    //单例
    private  UserUtils(){
         okHttpClient=new OkHttpClient();
    }
    public  static  synchronized  UserUtils getInstance(){
        if(userUtils==null){
            userUtils=new UserUtils();
        }
        return userUtils;
    }
    //请求数据
    public void doPost(String name, String pwd, final Handler handler) {
        FormBody.Builder formbody=new FormBody.Builder();
        formbody.add("phone",name);
        formbody.add("pwd",pwd);
        RequestBody body= formbody.build();
        Request request=new Request.Builder()
                .post(body)
                .url("http://172.17.8.100/small/user/v1/register")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
             Log.e("tag",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONObject object=new JSONObject(json);
                    String message = object.getString("message");
                    Message msg =new Message() ;
                    msg.obj=message;
                    handler.sendMessage(msg);
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
        RequestBody body= formbody.build();
        Request request=new Request.Builder()
                .post(body)
                .url("http://172.17.8.100/small/user/v1/login")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONObject object=new JSONObject(json);
                    String message = object.getString("message");
                    Message msg =new Message() ;
                    msg.obj=message;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
