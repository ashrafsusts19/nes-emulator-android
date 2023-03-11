package com.ashrafsusts19.nesemulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityHome extends AppCompatActivity {

    private ListView optionsList;
    private int STORAGE_PERMISSION_CODE = 1;
    private ArrayAdapter<String> optionsAdapter;
    ArrayList<String> options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        optionsList = findViewById(R.id.optionsList);
        options = new ArrayList<>(Arrays.asList("Load Rom", "Start", "Recent Games", "Options", "About",
                "Exit"));
        optionsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                options
        );
        optionsList.setAdapter(optionsAdapter);
        optionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivityHome.this, options.get(i), Toast.LENGTH_SHORT).show();
                switch(options.get(i)){
                    case "Load Rom":
                        loadRomOptionPressed();
                        break;
                    case "Start":
                        startOptionPressed();
                        break;
                    case "Recent Games":
                        recentGamesOptionPressed();
                        break;
                    case "Options":
                        optionsOptionPressed();
                        break;
                    case "About":
                        aboutOptionPressed();
                        break;
                    case "Exit":
                        exitOptionPressed();
                        break;
                }
            }
        });

    }

    private void loadRomOptionPressed(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){
            requestStoragePermission();
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            // TODO: load loadGameActivity
            Intent intent = new Intent(this, LoadGameActivity.class);
            startActivity(intent);
        }
    }

    private void startOptionPressed() {

    }

    private void recentGamesOptionPressed() {

    }

    private void optionsOptionPressed() {

    }

    private void aboutOptionPressed() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void exitOptionPressed() {

    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)){
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("Permission Needed to Access Storage")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(MainActivityHome.this, new String[]
                                    {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}