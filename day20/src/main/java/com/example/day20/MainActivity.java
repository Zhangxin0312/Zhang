package com.example.day20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
           MyLinearView myLinear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLinear=findViewById(R.id.myLinear);
    }

    public  void getNum(String name){
        Intent intent=new Intent(MainActivity.this,TwoActivity.class);
        startActivity(intent);

    }
}
