package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ashrafsusts19.nesemulator.views.GameCanvas;

import java.io.IOException;
import java.util.Timer;


public class GameFrameActivity extends AppCompatActivity{
    private class GameLoop implements Runnable{
        protected boolean isRunning = true;
        @Override
        public void run() {
            while (isRunning){
                GameFrameActivity.this.gameLoop();
                try {
                    Thread.sleep(GameFrameActivity.this.DELAY);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private String romLocation;
    private Bus nes;
    private Cartridge cart;
    private int DELAY = 5;
    private boolean bEmulationRun = true;
    private int frameSkip = 2;
    private int frameCount = 0;
    private Timer timer = new Timer();
    private GameCanvas gameCan;
    private Button b_up, b_down, b_left, b_right, b_a, b_b, b_start, b_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_frame);
        b_up = findViewById(R.id.button_up);
        b_down = findViewById(R.id.button_down);
        b_left = findViewById(R.id.button_left);
        b_right = findViewById(R.id.button_right);
        b_a = findViewById(R.id.button_a);
        b_b = findViewById(R.id.button_b);
        b_start = findViewById(R.id.button_start);
        b_select = findViewById(R.id.button_select);
        setupButtons();
        Intent intent = getIntent();
        romLocation = intent.getStringExtra(MainActivityHome.ROM_LOCATION_KEY);
//        Toast.makeText(this, romLocation, Toast.LENGTH_SHORT).show();
        try {
            cart = new Cartridge(this.romLocation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nes = new Bus();
        nes.insertCartridge(cart);
        nes.reset();
        gameCan = findViewById(R.id.gameCanvas);
        gameCan.setGameScreen(nes.ppu.getScreen());
        Runnable gameRunner = new GameLoop();
        Thread gameThread = new Thread(gameRunner);
        gameThread.start();
    }

    private void setupButtons() {
        b_b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x80;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x80;
                }
                return false;
            }
        });
        b_a.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x40;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x40;
                }
                return false;
            }
        });
        b_select.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x20;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x20;
                }
                return false;
            }
        });
        b_start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x10;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x10;
                }
                return false;
            }
        });
        b_up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x08;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x08;
                }
                return false;
            }
        });
        b_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x04;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x04;
                }
                return false;
            }
        });
        b_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x02;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x02;
                }
                return false;
            }
        });
        b_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    nes.controller[0] |= 0x01;
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    nes.controller[0] &= ~0x01;
                }
                return false;
            }
        });
    }

    private void gameLoop(){
        if (this.bEmulationRun){
            do {
                nes.clock();
            }
            while (!nes.ppu.frame_complete);
            nes.ppu.frame_complete = false;
        }
        if (frameCount == frameSkip){
            this.gameCan.invalidate();
            frameCount = 0;
        }
        else {
            frameCount++;
        }
    }
}