package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ashrafsusts19.nesemulator.views.GameCanvas;

public class GameFrameActivity extends AppCompatActivity {

    private String romLocation;
    GameCanvas gameCan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_frame);
        Intent intent = getIntent();
        romLocation = intent.getStringExtra(MainActivityHome.ROM_LOCATION_KEY);
//        Toast.makeText(this, romLocation, Toast.LENGTH_SHORT).show();
        gameCan  = new GameCanvas(this);
    }
}