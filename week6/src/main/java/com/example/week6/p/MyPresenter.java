package com.example.week6.p;

import android.util.Log;

import com.example.week6.bean.User;
import com.example.week6.m.MyModel;
import com.example.week6.m.MyModelInterface;
import com.example.week6.v.MyViewInterface;

public class MyPresenter implements MyPresenterInterface {
    MyModelInterface myModelInterface;
    MyViewInterface myViewInterface;
    public  MyPresenter(MyViewInterface myViewInterface){
        myModelInterface=new MyModel();
        this.myViewInterface=myViewInterface;
    }
    @Override
    public void Regist(String name, String pwd) {
          myModelInterface.toRegist(name, pwd, new MyModel.MyCallback() {
              @Override
              public void success(String str) {
                  myViewInterface.zhu(str);
              }
          });
    }

    @Override
    public void Login(String name, String pwd) {
        myModelInterface.toLogin(name, pwd, new MyModel.MyCallback() {
            @Override
            public void success(String str) {
                Log.e("tag",str);
                myViewInterface.deng(str);
            }
        });
    }

    @Override
    public void toModel() {
        myModelInterface.toRequest("http://api.expoon.com/AppNews/getNewsList/type/1/p/1", new MyModel.MyCallbacks() {
            @Override
            public void successful(Object obk) {
                if(obk instanceof User){
                    User user= (User) obk;
                    Log.e("sss",user.data.get(0).news_summary);
                    myViewInterface.notifys(user.data);
                }
            }
        });
    }

    @Override
    public void onDestory() {
        myViewInterface=null;
    }
}
