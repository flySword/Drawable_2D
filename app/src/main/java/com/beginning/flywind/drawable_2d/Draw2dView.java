package com.beginning.flywind.drawable_2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;

import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;



/**
 * Created by wind on 2015/2/9.
 */
public class Draw2dView extends View {

    int num_points;

    ShapeDrawable mShapeDrawable;
    private  int refreshTime;


    FlyPoint flyPoints[];

    public Draw2dView(Context context,AttributeSet attr){
        super(context,attr);
        num_points = 30;

        flyPoints = new FlyPoint[num_points];
        for(int i=0; i<num_points; i++){
            flyPoints[i] = new FlyPoint();
            flyPoints[i].setRandomCoord();
            flyPoints[i].setRandomVelocity();
            flyPoints[i].setRandomColor();
        }


        refreshTime = 20;

        RefreshHandler mRedrawHandler = new RefreshHandler();
        mRedrawHandler.sleep(50);


    }

    public void init(){

    }

    @Override
    protected void onDraw(Canvas canvas){
        Log.i("TAG", "onDraw");


//
//        RadialGradient radialGradient;
//
//        /*
//        RadialGradientRadialGradient(float centerX, float centerY, float radius,
//        int[] colors, float[] stops, Shader.TileMode tileMode)
//        centerX centerY is the coordinate which relatives to the ShapeDrawable
//        */
//        radialGradient = new RadialGradient(10,10,10,colors,null, Shader.TileMode.CLAMP);
//        mShapeDrawable.getPaint().setShader(radialGradient);
//        mShapeDrawable.setBounds(x,y,x+20,y+20);
//        mShapeDrawable.draw(canvas);

 //       for(int i=0; i<10; i++){


  //      }
        for(int i=0; i<num_points; i++){
            flyPoints[i].move();
            flyPoints[i].draw(canvas);
        }
    }


    class RefreshHandler extends android.os.Handler {

        @Override
        public void handleMessage(Message msg) {
            Draw2dView.this.invalidate();
            sleep(refreshTime);
        }

        public void sleep(long delayMillis) {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    }

    public void setRefreshTime(int time){
        refreshTime = time;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        for(int i=0; i<num_points; i++){
            flyPoints[i].setScreenSize(w,h);

        }
    }
}
