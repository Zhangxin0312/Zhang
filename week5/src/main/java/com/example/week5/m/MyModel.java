package com.example.week5.m;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.week5.p.MyPresenter;
import com.example.week5.p.MyPresenterInterface;
import com.example.week5.utils.UserUtils;

public class MyModel implements  MyModelInterface {
    MyCallback myCallback;
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String message= (String) msg.obj;
            Log.e("tag",message);
            myCallback.success(message);

        }
    };
    @Override
    public void Regists(String name, String pwd,MyCallback myCallback) {
        this.myCallback=myCallback;
        UserUtils utils = UserUtils.getInstance();
        utils.doPost(name,pwd,handler);
    }

    @Override
    public void Logins(String name, String pwd, MyCallback myCallback) {
        this.myCallback=myCallback;
        UserUtils utils = UserUtils.getInstance();
        utils.doPosts(name,pwd,handler);
    }

    public  interface  MyCallback{
        public  void  success(String str);
    }
}
