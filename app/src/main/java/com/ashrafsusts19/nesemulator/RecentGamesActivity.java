package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecentGamesActivity extends AppCompatActivity {

    private ListView listViewRecent;
    private ArrayList<String> filesList, locationList;
    private ArrayAdapter<String> filesListAdapter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_games);
        listViewRecent = findViewById(R.id.listRecentRoms);
        sharedPreferences = getSharedPreferences(MainActivityHome.SHARED_PREFS, MODE_PRIVATE);
        Set<String> filesSet = sharedPreferences.getStringSet(MainActivityHome.ROM_LOCATION_KEY, null);
        if (filesSet == null){
            filesSet = new HashSet<>();
        }
        filesList = new ArrayList<>();
        locationList = new ArrayList<>();
        for (String loc: filesSet){
            locationList.add(loc);
            int ind = loc.lastIndexOf("/");
            if (ind == -1) ind = 0;
            String fileName = loc.substring(ind);
            filesList.add(fileName);
        }
        filesList.add("Clear");
        filesListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                this.filesList);
        listViewRecent.setAdapter(this.filesListAdapter);
        listViewRecent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == filesList.size() - 1){

                }
                else {
                    clearRecentHistory();
                }
            }
        });
    }

    private void clearRecentHistory(){
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivityHome.SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> romLocs = new HashSet<>();
        editor.putStringSet(MainActivityHome.ROM_LOCATION_KEY, romLocs);
        filesList = new ArrayList<>();
        filesListAdapter.clear();
        filesListAdapter.addAll(filesList);
        filesListAdapter.notifyDataSetChanged();
    }

}