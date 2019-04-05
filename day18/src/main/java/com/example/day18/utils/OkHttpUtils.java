package com.example.day18.utils;

import android.os.Handler;
import android.os.Message;

import com.example.day18.m.MyModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
      static  OkHttpUtils okHttpUtils;
    OkHttpClient okHttpClient;
      private  OkHttpUtils(){
         okHttpClient=new OkHttpClient();
      }
      public  static  OkHttpUtils getInstance(){
          if(okHttpUtils==null){
              okHttpUtils=new OkHttpUtils();
          }
          return  okHttpUtils;
      }

    public void doGet(String url, final Handler handler, MyModel.MyCallback myCallback) {
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
                handler.sendMessage(message);
            }
        });
    }
}
