package com.beginning.flywind.drawable_2d;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

import java.util.Random;

/**
 * Created by wind on 2015/2/19.
 * the Point
 * 改进view中的3个for循环
 */
public class FlyPoint{
    int x;
    int y;
    int radial;

    //coordinate velocity of the point
    int v_x;
    int v_y;

    RadialGradient radialGradient;
 //   int color_num;
    int colors[][];

    int w_screen;
    int h_screen;

    private ShapeDrawable shapeDrawable;


    public FlyPoint(){
        shapeDrawable = new ShapeDrawable(new OvalShape());
        x = 10;
        y = 10;
        v_x = 1;
        v_y = 1;
        radial = 5;
        w_screen  = 250;
        h_screen = 300;

        colors = new int[3][2];
        colors[0][0] = Color.RED;
        colors[0][1] = Color.WHITE;
        colors[1][0] = Color.BLUE;
        colors[1][1] = Color.WHITE;
        colors[2][0] = Color.YELLOW;
        colors[2][1] = Color.WHITE;

        radialGradient = new RadialGradient(radial,radial,radial,colors[0],null, Shader.TileMode.CLAMP);
        shapeDrawable.getPaint().setShader(radialGradient);

        shapeDrawable.setBounds(x, y, x + 2 * radial, y + 2 * radial);

    }

    public  FlyPoint(int x_coord, int y_coord){
        x = x_coord;
        y = y_coord;
        radial = 10;

    }

    public void setRandomCoord(){
        Random random = new Random();
        x = random.nextInt(w_screen);
  //      y = random.nextInt(h_screen);

    }

    public void setRandomVelocity(){
        Random random = new Random();
        v_x = random.nextInt(2)+1;
        v_y = random.nextInt(2)+1;
    }

    public void setRandomColor(){
        Random random = new Random();
        int color_num =2;// random.nextInt(3);todo
        radialGradient = new RadialGradient(radial,radial,radial,colors[color_num],null, Shader.TileMode.CLAMP);
        shapeDrawable.getPaint().setShader(radialGradient);
    }

    public void move(){
        if (x>w_screen ){
            setRandomVelocity();
            x = 0;
        }

        if(y>h_screen){
            setRandomVelocity();
            y = 0;
        }

        x += v_x;
        y += v_y;
    }

    public void draw(Canvas canvas){
        shapeDrawable.setBounds(x, y, x + 2 * radial, y + 2 * radial);
        shapeDrawable.draw(canvas);
    }



    public void setScreenSize(int width, int height){
        w_screen = width;
        h_screen = height;
    }


}
