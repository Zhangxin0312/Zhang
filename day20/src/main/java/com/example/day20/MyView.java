package com.example.day20;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MyView  extends View {

     Paint paint;
     int h,y;
     int w,x;
    private ValueAnimator valueAnimator;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        w = getMeasuredWidth();
        h = getMeasuredHeight();
        y=h/2;
    }
         boolean flag=true;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path=new Path();
        path.moveTo(-w+x,y);
        path.quadTo(-w*4/3+x,y-60,-w/2+x,y);
        path.quadTo(-w/4+x,y+60,0+x,y);
        path.quadTo(w/4+x,y-60,w/2+x,y);
        path.quadTo(w/4*3+x,y+60,w+x,y);
        path.lineTo(w,h);
        path.lineTo(0,h);
        path.close();
        canvas.drawPath(path,paint);
        if(flag){
            startAnimator();
        }
    }
     public  void  startAnimator(){
         flag=false;
         valueAnimator = ValueAnimator.ofInt(0, w);
         valueAnimator.setDuration(3000);
         valueAnimator.setInterpolator(valueAnimator.getInterpolator());
         valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
         valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 x= (int) valueAnimator.getAnimatedValue();
                 postInvalidate();
             }
         });
         valueAnimator.start();
     }
}
