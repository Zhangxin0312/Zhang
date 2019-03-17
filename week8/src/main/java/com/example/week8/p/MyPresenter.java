package com.example.week8.p;

import com.example.week8.bean.Product;
import com.example.week8.contract.ContractInterface;
import com.example.week8.m.MyModel;

public class MyPresenter  implements ContractInterface.MyPersenterInterface {
    ContractInterface.LoginInterface loginInterface;
    ContractInterface.MyModelInterface myModelInterface;
    public  MyPresenter( ContractInterface.LoginInterface loginInterface){
        this.loginInterface=loginInterface;
        myModelInterface=new MyModel();
    }


    @Override
    public void toLogin(String name, String pwd) {
        myModelInterface.toLogins(name, pwd, "http://172.17.8.100/small/user/v1/login", new MyModel.MyCallBack() {
            @Override
            public void success(Object obj) {
                String str= (String) obj;
                loginInterface.Login(str);
            }
        });
    }

    @Override
    public void toRegist(String name, String pwd) {
        myModelInterface.toRegists(name, pwd, "http://172.17.8.100/small/user/v1/register", new MyModel.MyCallBack() {
            @Override
            public void success(Object obj) {
                String str= (String) obj;
                loginInterface.Regist(str);
            }
        });
    }

    @Override
    public void toModel() {
        myModelInterface.toRequest("http://api.expoon.com/AppNews/getNewsList/type/1/p/1", new MyModel.MyCallBack() {
            @Override
            public void success(Object obj) {
                 if(obj instanceof Product){
                     Product product= (Product) obj;
                     loginInterface.notifys(product.getData());
                 }
            }
        });
    }
}
