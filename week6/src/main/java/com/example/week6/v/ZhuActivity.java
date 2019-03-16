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

public class ZhuActivity extends AppCompatActivity implements MyViewInterface{
       MyPresenterInterface myPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        myPresenterInterface=new MyPresenter(this);
        final EditText zhu_name= findViewById(R.id.zhu_name);
        final EditText zhu_pwd= findViewById(R.id.zhu_pwd);
        Button zhu_regist= findViewById(R.id.zhu_regist);
        zhu_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = zhu_name.getText().toString();
                String pwd = zhu_pwd.getText().toString();
                myPresenterInterface.Regist(name,pwd);
            }
        });
    }

    @Override
    public void deng(String str) {

    }

    @Override
    public void zhu(String str) {
        Toast.makeText(ZhuActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("注册成功")){
            Intent intent =new Intent(ZhuActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void notifys(List<User.AAA> list) {

    }
    public  void onDestory(){
        myPresenterInterface.onDestory();
        myPresenterInterface=null;
    }
}
