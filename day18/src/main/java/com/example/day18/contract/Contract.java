package com.example.day18.contract;

import com.example.day18.bean.Product;
import com.example.day18.m.MyModel;

import java.util.List;

public interface Contract {

    public  interface  MyPresenterInterface{
        public  void toModel();
    }
    public  interface  MyModelInterface{
        public  void toRequest(String url, MyModel.MyCallback myCallback);
    }
    public  interface  MyViewInterface{
        public  void notifys(List<Product.DataBean>   list);
    }
}
