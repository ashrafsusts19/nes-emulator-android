package com.ashrafsusts19.nesemulator.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.ashrafsusts19.nesemulator.Olc2C02A;
import com.ashrafsusts19.nesemulator.Olc6502;

public class GameCanvas extends View {

    private Olc2C02A.Sprite gameScreen;
    private Paint painter;
    public float pixelWidth = 1.0f, pixelHeight = 1.0f;
    public int pixelWidthInt = 1, pixelHeightInt = 1;
    private int startx = 0, starty = 0, canvasWidth, canvasHeight;
    Bitmap gameScreenBM, testBM;
    private int counter = 0;

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
        this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                GameCanvas.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                init2();
            }
        });
    }

    private void init2(){
        this.painter = new Paint();
        this.pixelWidth = this.getWidth() / 256.0f;
        this.pixelHeight = this.getHeight() / 240.0f;
        this.pixelWidthInt = this.getWidth() / 256;
        this.pixelHeightInt = this.getHeight() / 240;
        this.canvasHeight = this.pixelHeightInt * 240;
        this.canvasWidth = this.pixelWidthInt * 256;
        this.startx = (this.getWidth() - this.canvasWidth) / 2;
        this.starty = (this.getHeight() - this.canvasHeight) / 2;
        this.gameScreenBM = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_4444);
    }

    public void setGameScreen(Olc2C02A.Sprite sprite){
        this.gameScreen = sprite;
    }

    public void drawSprite(int x, int y, Canvas canvas){
        Olc2C02A.Sprite sprite = this.gameScreen;
        for (int ir = 0; ir < sprite.height; ir++){
            for (int ic = 0; ic < sprite.width; ic++){
                Olc2C02A.Pixel p = sprite.getPixel(ic, ir);
                if (p.a != 0){
                    int pr = p.r, pg = p.g, pb = p.b, pa = p.a;
                    for (int i = 0; i < this.pixelHeightInt; i++){
                        for (int j = 0; j < this.pixelWidthInt; j++){
                            gameScreenBM.setPixel(ic * this.pixelWidthInt + j, ir * this.pixelHeightInt + i,
                                    Color.argb(pa, pr, pg, pb));
                        }
                    }
//                    gameScreenBM.setPixel(ic, ir, Color.argb(pa, pr, pg, pb));
                }
            }
        }
        canvas.drawBitmap(gameScreenBM, x, y, painter);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#000000"));
        if (this.gameScreen != null){
            drawSprite(startx, starty, canvas);
        }
        else {
            System.out.println("No gameScreen");
        }
    }


}
