package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

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
    ArrayList<String> options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        optionsList = findViewById(R.id.optionsList);
        options = new ArrayList<>(Arrays.asList("Load Rom", "Start", "Recent Games", "Options", "About",
                "Exit"));
        ArrayAdapter<String> optionsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                options
        );
        optionsList.setAdapter(optionsAdapter);
        optionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivityHome.this, options.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}