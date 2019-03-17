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

public class MainActivity extends AppCompatActivity implements ContractInterface.LoginInterface {
     EditText name;
    EditText pwd;
    Button login;
    Button  regist;
    ContractInterface.MyPersenterInterface myPersenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPersenterInterface=new MyPresenter(this);
        name=findViewById(R.id.name);
        pwd= findViewById(R.id.pwd);
        login=findViewById(R.id.login);
        regist=findViewById(R.id.regist);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1= name.getText().toString();
                String pwd1= pwd.getText().toString();
                myPersenterInterface.toLogin(name1,pwd1);

            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ZhuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Login(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("登录成功")){
            Intent intent =new Intent(MainActivity.this,ShowActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void Regist(String str) {

    }

    @Override
    public void notifys(List<Product.DataBean> list) {

    }
}
