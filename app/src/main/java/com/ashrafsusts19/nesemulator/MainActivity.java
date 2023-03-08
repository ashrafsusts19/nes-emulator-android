package com.ashrafsusts19.nesemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txt;
    EditText editText;
    int count = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = new Button(this);

        txt = findViewById(R.id.textView);
        txt.setText("You pressed " + count + " times");
        editText = findViewById(R.id.editText1);
        findViewById(R.id.layoutOption1).setOnClickListener(this);
        findViewById(R.id.layoutOption2).setOnClickListener(this);

    }

    public void btn1OnClick(View view){
        String name = editText.getText().toString();
        this.count++;
        txt.setText(name + " pressed " + count + " times");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layoutOption1:
                Toast.makeText(this, "You have selected Option 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layoutOption2:
                Toast.makeText(this, "You have selected Option 2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}