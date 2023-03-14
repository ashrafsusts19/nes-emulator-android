package com.ashrafsusts19.nesemulator.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameCanvas extends View {


    public GameCanvas(Context context) {
        super(context);
        init();
    }

    public GameCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#000000"));
    }


}
