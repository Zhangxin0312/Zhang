package com.example.week6.v;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.week6.R;
import com.example.week6.bean.User;
import com.example.week6.p.MyPresenter;
import com.example.week6.p.MyPresenterInterface;

import java.util.List;

public class LoginActivity extends AppCompatActivity  implements  MyViewInterface{
   MyPresenterInterface myPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPresenterInterface=new MyPresenter(this);
        final EditText name= findViewById(R.id.name);
        final EditText pwd= findViewById(R.id.pwd);
        Button login= findViewById(R.id.login);
        Button regist= findViewById(R.id.regist);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String pwd1 = pwd.getText().toString();
                myPresenterInterface.Login(name1,pwd1);
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this,ZhuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void deng(String str) {
        Toast.makeText(LoginActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("登录成功")){
            Intent intent =new Intent(LoginActivity.this,ShowActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void zhu(String str) {

    }

    @Override
    public void notifys(List<User.AAA> list) {

    }
    public  void onDestory(){
        myPresenterInterface.onDestory();
        myPresenterInterface=null;
    }
}
