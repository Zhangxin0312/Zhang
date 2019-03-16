package com.example.week5.p;

import com.example.week5.m.MyModel;
import com.example.week5.m.MyModelInterface;
import com.example.week5.v.MyViewInterfaace;

public class MyPresenter implements  MyPresenterInterface {
    MyViewInterfaace myViewInterfaace;
    MyModelInterface myModelInterface;
    public MyPresenter(MyViewInterfaace myViewInterfaace) {
        this.myViewInterfaace=myViewInterfaace;
        myModelInterface=new MyModel();
    }

    @Override
    public void toRegist(String name, String pwd) {

        myModelInterface.Regists(name, pwd, new MyModel.MyCallback() {
            @Override
            public void success(String str) {
               myViewInterfaace.zhu(str);
            }
        });
    }

    @Override
    public void toLogin(String name, String pwd) {
         myModelInterface.Logins(name, pwd, new MyModel.MyCallback() {
             @Override
             public void success(String str) {
                 myViewInterfaace.login(str);
             }
         });
    }
}
