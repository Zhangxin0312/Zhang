package com.example.day20;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MyLinearView  extends LinearLayout {
    Button btn;
    MyLiuView myLiu;
    EditText name;
    MainActivity activity;
    public MyLinearView(Context context) {
        super(context);
    }

    public MyLinearView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        activity= (MainActivity) context;
        View view=LayoutInflater.from(context).inflate(R.layout.item,this);
         name=view.findViewById(R.id.name);
         btn=view.findViewById(R.id.btn);
        myLiu=view.findViewById(R.id.myLiu);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = name.getText().toString();
                final Button button=new Button(context);
                button.setText(content);
                myLiu.addView(button);
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        activity.getNum(button.getText().toString());
                    }
                });
                button.setOnLongClickListener(new OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                         button.setVisibility(View.GONE);
                        return true;
                    }
                });
            }
        });
    }
}
