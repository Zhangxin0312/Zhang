package com.example.day20;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyLiuView   extends ViewGroup {
    int  mLeftMargin=20;
    int  mTopMargin=20;
    public MyLiuView(Context context) {
        super(context);
    }

    public MyLiuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
          int leftMargin=mLeftMargin;
          int topMargin=mTopMargin;
        for (int j = 0; j <getChildCount() ; j++) {
            int measuredHeight = getChildAt(j).getMeasuredHeight();
            int measuredWidth = getChildAt(j).getMeasuredWidth();
            if(getChildAt(j).getVisibility()==View.GONE){
                continue;
            }
            if(leftMargin+measuredWidth+mLeftMargin>getWidth()){
                leftMargin=mLeftMargin;
                topMargin+=mTopMargin+measuredHeight;
                getChildAt(j).layout(leftMargin,topMargin,leftMargin+measuredWidth,topMargin+measuredHeight);
            }else
            {
                getChildAt(j).layout(leftMargin,topMargin,leftMargin+measuredWidth,topMargin+measuredHeight);
            }
            leftMargin+=mLeftMargin+measuredWidth;
        }
    }
}
