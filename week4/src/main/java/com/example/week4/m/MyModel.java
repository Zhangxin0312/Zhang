package com.example.week4.m;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.week4.bean.Product;
import com.example.week4.bean.User;
import com.example.week4.contract.Contract;
import com.example.week4.utils.OkHttpUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MyModel  implements Contract.MyModelInterface {
    MyCallBack myCallBack;
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String json= (String) msg.obj;
            int type=msg.arg1;
            Gson gson=new Gson();
            switch (type){
                case 1:
                    try {
                        JSONObject object=new JSONObject(json);
                        String message = object.getString("message");
                        myCallBack.success(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:

                    Product product = gson.fromJson(json, Product.class);
                    product.getData().remove(0);
                    myCallBack.success(product);
                    break;
                case 3:
                    User user = gson.fromJson(json, User.class);

                    myCallBack.success(user);
                    break;
            }

        }
    };
    @Override
    public void toLogin(String url, String phone, String pwd,MyCallBack myCallBack) {
            this.myCallBack=myCallBack;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doPost(url,phone,pwd,handler,myCallBack);
    }

    @Override
    public void toRegist(String url, String phone, String pwd,MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doPost(url,phone,pwd,handler,myCallBack);
    }

    @Override
    public void toRequest(String url, MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doGet(url,handler,myCallBack);
    }

    @Override
    public void toRequests(String url, int id, MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doGets(url,id,handler,myCallBack);
    }

    public  interface  MyCallBack{
          public  void success(Object object);
    }
}
