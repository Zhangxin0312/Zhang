package com.example.week4.contract;

import com.example.week4.bean.Product;
import com.example.week4.bean.User;
import com.example.week4.m.MyModel;

import java.util.List;


public interface Contract {

    public  interface  MyPresenterInterface{
        public  void Login(String phone,String pwd);
        public  void Regist(String phone,String pwd);
        public  void  toModel();
        public  void  toModels(int id);
    }
    public  interface  MyModelInterface{
        public  void toLogin(String url, String phone, String pwd, MyModel.MyCallBack myCallBack);
        public  void toRegist(String url, String phone, String pwd, MyModel.MyCallBack myCallBack);
        public  void  toRequest(String url, MyModel.MyCallBack myCallBack);
        public  void  toRequests(String url, int id,MyModel.MyCallBack myCallBack);
    }
    public  interface  MyLoginInterface{
        public  void      Logins(String str);

    }
    public  interface  MyRegistInterface{
        public  void     Regists(String str);

    }
    public  interface  MyViewInterface{
        public  void    notitys(List<Product.DataBean> list);

    }
    public  interface  MyViewInterfaces{
        public  void    notitya(User user);

    }
}
