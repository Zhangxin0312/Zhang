package com.example.week8.m;

import android.os.Handler;
import android.os.Message;

import com.example.week8.bean.Product;
import com.example.week8.contract.ContractInterface;
import com.example.week8.utils.OkHttpUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


public class MyModel  implements ContractInterface.MyModelInterface {
    MyCallBack myCallBack;
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String json= (String) msg.obj;
            int type=msg.arg1;
            switch (type){
                case 1:
                    try {
                        JSONObject object=new JSONObject(json);
                        String message=object.getString("message");
                        myCallBack.success(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    Gson gson=new Gson();
                    Product product = gson.fromJson(json, Product.class);
                    myCallBack.success(product);
                    break;
            }
        }
    };

    @Override
    public void toLogins(String name, String pwd, String url, MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doPost(name,pwd,url,handler);
    }

    @Override
    public void toRegists(String name, String pwd, String url, MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doPost(name,pwd,url,handler);
    }

    @Override
    public void toRequest(String url, MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        OkHttpUtils utils = OkHttpUtils.getInstance();
        utils.doGet(url,handler);
    }

    public  interface  MyCallBack{
        public  void success(Object obj);
    }
}
