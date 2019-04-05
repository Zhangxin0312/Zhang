package com.example.day18.m;

import android.os.Handler;
import android.os.Message;

import com.example.day18.bean.Product;
import com.example.day18.contract.Contract;
import com.example.day18.utils.OkHttpUtils;
import com.google.gson.Gson;

public class MyModel  implements Contract.MyModelInterface {
    MyCallback myCallback;
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
             String json= (String) msg.obj;
            Gson gson=new Gson();
            Product product = gson.fromJson(json, Product.class);
          product.getData().remove(0);
            myCallback.success(product);
        }
    };
    @Override
    public void toRequest(String url,MyCallback myCallback) {
        this.myCallback=myCallback;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doGet(url,handler,myCallback);
    }

    public  interface  MyCallback{
        public   void success(Object   object);
    }
}
