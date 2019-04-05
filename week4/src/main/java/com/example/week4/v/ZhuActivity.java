package com.example.week4.v;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week4.R;
import com.example.week4.contract.Contract;
import com.example.week4.p.MyPresenter;

public class ZhuActivity extends AppCompatActivity implements  Contract.MyRegistInterface{
    EditText zhu_phone,zhu_pwd;
    Button zhu_regist;
    TextView jumps;
    Contract.MyPresenterInterface myPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        zhu_phone=findViewById(R.id.zhu_phone);
        zhu_pwd=findViewById(R.id.zhu_pwd);
        zhu_regist=findViewById(R.id.zhu_regist);
        jumps=findViewById(R.id.jumps);
        myPresenterInterface=new MyPresenter<>(this);
        zhu_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = zhu_phone.getText().toString();
                String pwd = zhu_pwd.getText().toString();
                myPresenterInterface.Regist(phone,pwd);
            }
        });
        jumps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ZhuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Regists(String str) {
        Toast.makeText(ZhuActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("注册成功")){
            Intent intent=new Intent(ZhuActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
