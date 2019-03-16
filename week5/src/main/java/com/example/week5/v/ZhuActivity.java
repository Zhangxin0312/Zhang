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

public class ZhuActivity extends AppCompatActivity  implements  MyViewInterfaace{
    MyPresenterInterface myPresenterInterface;
    private EditText zhu_pwd;
    private EditText zhu_name;
    private Button zhu_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        myPresenterInterface=new MyPresenter(this);
        zhu_name = findViewById(R.id.zhu_name);
        zhu_pwd = findViewById(R.id.zhu_pwd);
        zhu_regist = findViewById(R.id.zhu_regist);
        zhu_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name2 = zhu_name.getText().toString();
                String pwd2 = zhu_pwd.getText().toString();
                myPresenterInterface.toRegist(name2,pwd2);
            }
        });
    }

    @Override
    public void zhu(String str) {
        Toast.makeText(ZhuActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("注册成功")){
            Intent intent =new Intent(ZhuActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void login(String str) {

    }
}
