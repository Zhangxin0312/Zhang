package com.example.day18.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.day18.R;

public class MyButton extends LinearLayout {
        public Button jia;
        public Button jian;
        public  TextView ttv;
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=LayoutInflater.from(context).inflate(R.layout.btn_item,this);
        jian=  view.findViewById(R.id.jian);
        jia=  view.findViewById(R.id.jia);
        ttv=  view.findViewById(R.id.ttv);

    }

}
