package com.example.week8.v;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.week8.R;
import com.example.week8.bean.Product;
import com.example.week8.contract.ContractInterface;
import com.example.week8.p.MyPresenter;

import java.util.List;

public class ZhuActivity extends AppCompatActivity implements ContractInterface.LoginInterface {
    EditText zhu_name;
    EditText zhu_pwd;
    Button  zhu_regist;
    ContractInterface.MyPersenterInterface myPersenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        myPersenterInterface=new MyPresenter(this);
        zhu_name=findViewById(R.id.zhu_name);
        zhu_pwd= findViewById(R.id.zhu_pwd);
        zhu_regist=findViewById(R.id.zhu_regist);
        zhu_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= zhu_name.getText().toString();
                String pwd= zhu_pwd.getText().toString();
                myPersenterInterface.toRegist(name,pwd);
            }
        });
    }

    @Override
    public void Login(String str) {

    }

    @Override
    public void Regist(String str) {
        Toast.makeText(ZhuActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("注册成功")){
            Intent intent =new Intent(ZhuActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void notifys(List<Product.DataBean> list) {

    }
}
