package com.example.week4.p;

import android.util.Log;

import com.example.week4.bean.Product;
import com.example.week4.bean.User;
import com.example.week4.contract.Contract;
import com.example.week4.m.MyModel;

public class MyPresenter<T>  implements Contract.MyPresenterInterface {
    Contract.MyModelInterface myModelInterface;
    T  views;
    public  MyPresenter(T view){
        myModelInterface=new MyModel();
        this.views=view;
    }
    @Override
    public void Login(String phone, String pwd) {
          myModelInterface.toLogin("http://172.17.8.100/small/user/v1/login",phone,pwd, new MyModel.MyCallBack() {
              @Override
              public void success(Object object) {
                   String str= (String) object;
                   Contract.MyLoginInterface myLoginInterface= (Contract.MyLoginInterface) views;
                   myLoginInterface.Logins(str);
              }
          });
    }

    @Override
    public void Regist(String phone, String pwd) {
           myModelInterface.toRegist("http://172.17.8.100/small/user/v1/register",phone,pwd , new MyModel.MyCallBack() {
               @Override
               public void success(Object object) {
                   String str= (String) object;
                   Contract.MyRegistInterface myRegistInterface= (Contract.MyRegistInterface) views;
                   myRegistInterface.Regists(str);
               }
           });
    }

    @Override
    public void toModel() {
        myModelInterface.toRequest("http://172.17.8.100/ks/product/getCarts?uid=51", new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                if(object instanceof Product){
                    Product product= (Product) object;
                    Contract.MyViewInterface myViewInterface= (Contract.MyViewInterface) views;
                    myViewInterface.notitys(product.getData());
                }
            }
        });
    }

    @Override
    public void toModels(int id) {
        myModelInterface.toRequests("http://172.17.8.100/ks/product/getProductDetail?pid=",id, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                  if(object instanceof User){
                      User user= (User) object;

                      Contract.MyViewInterfaces myViewInterfaces= (Contract.MyViewInterfaces) views;
                      myViewInterfaces.notitya(user);
                  }
            }
        });
    }
}
