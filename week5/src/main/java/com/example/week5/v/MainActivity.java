package com.example.week5.v;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.week5.R;
import com.example.week5.p.MyPresenter;
import com.example.week5.p.MyPresenterInterface;

public class MainActivity extends AppCompatActivity implements  MyViewInterfaace{

    public EditText name;
    public EditText pwd;
    public Button login;
    public Button regist;
    MyPresenterInterface myPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         myPresenterInterface=new MyPresenter(this);
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        regist = findViewById(R.id.regist);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String pwd1 = pwd.getText().toString();
                myPresenterInterface.toLogin(name1,pwd1);
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ZhuActivity.class);
               startActivity(intent);

            }
        });

    }

    @Override
    public void zhu(String str) {

    }

    @Override
    public void login(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("登录成功")){
            Intent intent =new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
