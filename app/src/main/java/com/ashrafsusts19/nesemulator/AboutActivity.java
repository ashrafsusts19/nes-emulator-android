package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    private TextView textAbout;
    private String aboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutUs = "This Project was created by:\n" +
                "Ashraf Ibrahim (2019831072)\n" +
                "Md Ibrahim (2019831036)\n" +
                "Sust SWE batch - 19\n" +
                "\n" +
                "\n" +
                "The project was made possible using the NES emulator tutorial made by " +
                "Javidx. Huge thanks for in-depth and detailed explanations.\n" +
                "Code of the original project (written in C++) was taken, modified and rebuilt " +
                "to fit within the Java framework. The project is nowhere near optimzed enough " +
                "for commercial use, but we wanted to able to emulate an actual NES emulator rom " +
                "within our project successfully. Which we are happy to accomplish.\n";
        textAbout = findViewById(R.id.textAbout);
        textAbout.setText(aboutUs);
    }
}