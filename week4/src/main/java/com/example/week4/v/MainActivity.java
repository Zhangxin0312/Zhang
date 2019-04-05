package com.example.week4.v;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week4.R;
import com.example.week4.contract.Contract;
import com.example.week4.fragment.MyFragment;
import com.example.week4.fragment.ShouFragment;
import com.example.week4.p.MyPresenter;

public class MainActivity extends FragmentActivity  implements Contract.MyLoginInterface {
        EditText phone,pwd;
        Button login;
        TextView jump;
        Contract.MyPresenterInterface myPresenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.phone);
        pwd=findViewById(R.id.pwd);
        login=findViewById(R.id.login);
        jump=findViewById(R.id.jump);
        myPresenterInterface=new MyPresenter<>(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone1 = phone.getText().toString();
                String pwd1 = pwd.getText().toString();
               myPresenterInterface.Login(phone1,pwd1);
            }
        });
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ZhuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Logins(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
        if(str.equals("登录成功")){
            Intent intent=new Intent(MainActivity.this,ShowActivity.class);
            startActivity(intent);
        }
    }
}
