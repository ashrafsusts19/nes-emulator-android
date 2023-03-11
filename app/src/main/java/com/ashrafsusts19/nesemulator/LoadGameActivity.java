package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class LoadGameActivity extends AppCompatActivity {

    private String currentPath;
    private String previousPath;
    private ArrayList<String> filesList;
    private ArrayAdapter<String> filesListAdapter;
    private ListView listViewDir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        listViewDir = findViewById(R.id.directoryFilesList);

        currentPath = Environment.getExternalStorageDirectory().getPath();
        previousPath = currentPath;
        Toast.makeText(this, currentPath, Toast.LENGTH_SHORT).show();
        File directory = new File(currentPath);
        File[] files  = directory.listFiles();
        filesList = new ArrayList<>();
        for (File f: files){
            if (f.isDirectory()) {
                filesList.add(f.getName());
            }
//            else if (f.getPath().substring(f.getPath().lastIndexOf(".")) == "nes"){
//                System.out.println("NES file found: " + f.getName());
//            }
            else {
                int dotPosition = f.getPath().lastIndexOf(".");
                if (dotPosition != -1) {
                    String ext = f.getPath().substring(dotPosition);
                    if (ext == ".nes"){
                        filesList.add(f.getName());
                    }
                }
                System.out.println("Not Folder found: " + f.getName());
            }
        }
        filesListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                this.filesList);
        listViewDir.setAdapter(this.filesListAdapter);
        listViewDir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                updateDirectory(filesList.get(i));
            }
        });
    }

    private void updateDirectory(String file){

        String newPath = currentPath + "/" + file;
        File dir = new File(newPath);
        if (dir.isDirectory()){
//            Toast.makeText(this, "Selected " + file, Toast.LENGTH_SHORT).show();
            File[] files = dir.listFiles();
            filesList = new ArrayList<>();
            for (File f: files){
                if (f.isDirectory()) {
                    filesList.add(f.getName());
                }
//                else if (f.getPath().substring(f.getPath().lastIndexOf(".")) == "nes"){
//                    System.out.println("NES file found: " + f.getName());
//                }
                else {
                    int dotPosition = f.getPath().lastIndexOf(".");
                    if (dotPosition != -1) {
                        String ext = f.getPath().substring(dotPosition);
                        if (ext.equals(".nes")){
//                            System.out.println("Nes Rom found: " + f.getName());
                            filesList.add(f.getName());
                        }
                        System.out.println(ext);
                    }
//                    System.out.println("Not Folder found: " + f.getName());

                }
            }
            filesListAdapter.clear();
            filesListAdapter.addAll(filesList);
            filesListAdapter.notifyDataSetChanged();
//            filesListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//                    this.filesList);
//            listViewDir.setAdapter(this.filesListAdapter);
        }
        else {
            int dotPosition = dir.getPath().lastIndexOf(".");
            if (dotPosition != -1) {
                String ext = dir.getPath().substring(dotPosition);
                if (ext.equals(".nes")){
                    Toast.makeText(this, "You found a nes game, YAY", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}