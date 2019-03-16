package com.example.week6.m;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.week6.bean.User;
import com.example.week6.utils.UserUtils;
import com.google.gson.Gson;

public class MyModel  implements  MyModelInterface {
    MyCallback myCallback;
    MyCallbacks myCallbacks;

    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

               int type= msg.arg1;
               switch (type){
                   case 1:
                       String message= (String) msg.obj;
                       myCallback.success(message);
                       break;
                   case 2:
                       String message1= (String) msg.obj;
                       myCallback.success(message1);
                       break;
                   case 3:
                       String json= (String) msg.obj;

                       Gson gson=new Gson();
                       User user = gson.fromJson(json, User.class);

                       myCallbacks.successful(user);
                       break;
               }

        }
    };
    @Override
    public void toRegist(String name, String pwd,MyCallback myCallback) {
        this.myCallback=myCallback;
        UserUtils utils = UserUtils.getInstance();
        utils.doPost(name,pwd,handler);
    }

    @Override
    public void toLogin(String name, String pwd, MyCallback myCallback) {
        this.myCallback=myCallback;
        UserUtils utils = UserUtils.getInstance();
        utils.doPosts(name,pwd,handler);
    }

    @Override
    public void toRequest(String url, MyCallbacks myCallbacks) {
        this.myCallbacks=myCallbacks;
        UserUtils utils = UserUtils.getInstance();
        utils.doGet(url,handler);
    }


    public  interface  MyCallback{
        public  void success(String str);
    }
    public  interface  MyCallbacks{
        public  void successful(Object obk);
    }
}
