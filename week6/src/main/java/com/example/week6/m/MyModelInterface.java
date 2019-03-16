package com.example.week6.m;

public interface MyModelInterface  {
    public  void toRegist(String name,String pwd,MyModel.MyCallback myCallback);
    public  void toLogin(String name,String pwd,MyModel.MyCallback myCallback);

     public  void toRequest(String url, MyModel.MyCallbacks myCallbacks);
}
