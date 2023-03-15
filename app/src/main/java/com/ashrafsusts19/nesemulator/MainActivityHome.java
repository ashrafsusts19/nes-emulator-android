package com.ashrafsusts19.nesemulator;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivityHome extends AppCompatActivity {

    public static final String ROM_LOCATION_KEY = "ROM_LOCATION";
    public static final String SHARED_PREFS = "SHARED_PREFERENCES";
    private String romLocation = null;
    private ListView optionsList;
    private int STORAGE_PERMISSION_CODE = 1;
    private ArrayAdapter<String> optionsAdapter;
    ArrayList<String> options;
    ActivityResultLauncher<Intent> startForResultRomLocation =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result != null && result.getResultCode() == RESULT_OK){
                                if (result.getData() != null && result.getData().getStringExtra(ROM_LOCATION_KEY) != null){
                                    attemptRomInsert(result.getData().getStringExtra(ROM_LOCATION_KEY));
                                }
                            }
                        }
                    });
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

    private void attemptRomInsert(String location){
        if (isValidRom(location)){
            this.romLocation = location;
            TextView tv = findViewById(R.id.textLoadedRom);
            tv.setText(romLocation.substring(romLocation.lastIndexOf("/") + 1));

        }
        else {
            this.romLocation = null;
            TextView tv = findViewById(R.id.textLoadedRom);
            tv.setText("None");
            Toast.makeText(MainActivityHome.this, "Invalid Rom", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidRom(String location){
        File rom = new File(location);
        int dotPosition = rom.getPath().lastIndexOf(".");
        if (dotPosition != -1) {
            String ext = rom.getPath().substring(dotPosition);
            if (ext.equals(".nes")){
                byte[] header = new byte[16];
                InputStream cartFile = null;
                try {
                    cartFile = new FileInputStream(location);
                    cartFile.read(header);
                    if (header[0] == (byte) 0x4e && header[1] == (byte) 0x45 && header[2] == (byte) 0x53){
                        return true;
                    }

                } catch (FileNotFoundException e) {
                    return false;
                } catch (IOException e) {
                    return false;
                }
            }
        }
        return false;
    }

    private void loadRomOptionPressed(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){
            requestStoragePermission();
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoadGameActivity.class);

            startForResultRomLocation.launch(intent);
        }
        else {
//            Intent intent = new Intent(this, LoadGameActivity.class);
//
//            startForResultRomLocation.launch(intent);
        }
    }

    private void startOptionPressed() {
        if (this.romLocation == null){
            Toast.makeText(this, "Load Valid Rom", Toast.LENGTH_SHORT).show();
            return;
        }
        addRomData(this.romLocation);
        Intent intent = new Intent(this, GameFrameActivity.class);
        intent.putExtra(ROM_LOCATION_KEY, romLocation);
        startActivity(intent);
    }

    private void addRomData(String data){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> romLocs;
        romLocs = sharedPreferences.getStringSet(ROM_LOCATION_KEY, null);
        if (romLocs == null){
            romLocs = new HashSet<>();
        }
        for (String s: romLocs){
            System.out.println(s);
        }
        romLocs.add(data);
        editor.putStringSet(ROM_LOCATION_KEY, romLocs);

    }

    private void recentGamesOptionPressed() {
        Intent intent = new Intent(this, RecentGamesActivity.class);

        startForResultRomLocation.launch(intent);
    }

    private void optionsOptionPressed() {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    private void aboutOptionPressed() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void exitOptionPressed() {
        System.exit(0);
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