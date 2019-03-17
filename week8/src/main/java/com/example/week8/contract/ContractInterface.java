package com.example.week8.contract;

import com.example.week8.bean.Product;
import com.example.week8.m.MyModel;

import java.util.List;

public interface ContractInterface {


    public  interface  LoginInterface{
        public  void Login(String str);
        public  void Regist(String str);
        public  void notifys(List<Product.DataBean> list);

    }
    public  interface  MyPersenterInterface{
        public void toLogin(String name,String pwd);
        public void toRegist(String name,String pwd);
        public void  toModel();
    }
    public  interface MyModelInterface{
        public  void toLogins(String name, String pwd, String url, MyModel.MyCallBack myCallBack);
        public  void toRegists(String name, String pwd, String url, MyModel.MyCallBack myCallBack);
        public  void  toRequest( String url, MyModel.MyCallBack myCallBack);
    }
}
