package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.widget.Toast;

import com.ashrafsusts19.nesemulator.views.GameCanvas;

import java.io.IOException;
import java.util.Timer;


public class GameFrameActivity extends AppCompatActivity {
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
    GameCanvas gameCan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_frame);
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