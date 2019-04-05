package com.example.week4.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MyLangView  extends View {
    int w,h,y,x;
    private Paint paint;
    private ValueAnimator valueAnimator;

    public MyLangView(Context context) {
        super(context);
    }

    public MyLangView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
         h = getMeasuredHeight();
         w = getMeasuredWidth();
         y=h/2;
    }
    boolean flag=true;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path=new Path();
        path.moveTo(-w+x,y);
        path.quadTo(-w/4*3+x,y-60,-w/2+x,y);
        path.quadTo(-w/4+x,y+60,0+x,y);
        path.quadTo(w/4+x,y-60,w/2+x,y);
        path.quadTo(w/4*3+x,y+60,w+x,y);
        path.lineTo(w,h);
        path.lineTo(0,h);
        path.close();
        canvas.drawPath(path,paint);
        if(flag){
            startAimator();
        }

    }
     public  void  startAimator(){
        flag=false;
         valueAnimator = ValueAnimator.ofInt(0, w);
         valueAnimator.setDuration(3000);
         valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
         valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 x= (int) valueAnimator.getAnimatedValue();

                 invalidate();
             }
         });
         valueAnimator.start();
     }
}
