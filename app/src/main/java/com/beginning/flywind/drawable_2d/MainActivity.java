package com.beginning.flywind.drawable_2d;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


public class MainActivity extends Activity {

    private final String TAG = "MainActivity";
    private Draw2dView mDrawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawView = (Draw2dView) findViewById(R.id.Draw2dView);

    }

    public void btn1_onClick(View view ){
        Log.i(TAG, "btn1 Clicked");
        mDrawView.init();//error调用不了mDrawView中的方法？？
        // setContentView(R.layout.activity_main);要在定义mDrawView之前
    }


}
