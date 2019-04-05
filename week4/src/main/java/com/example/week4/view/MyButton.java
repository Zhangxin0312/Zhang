package com.example.week4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week4.R;

public class MyButton  extends LinearLayout {
     public    Button jia ,jian;
    public TextView  tvv;
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=LayoutInflater.from(context).inflate(R.layout.my_btn,this);
         jian=view.findViewById(R.id.jian);
        jia=view.findViewById(R.id.jia);
        tvv=view.findViewById(R.id.tvv);

    }
}
