package com.example.labo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    MySharedPreference mySharedPreference;
    TextView textView;
    TextView textViewExtra;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mySharedPreference = new MySharedPreference(this);
        textView = findViewById(R.id.textView);
        textViewExtra = findViewById(R.id.extra);
        String output = mySharedPreference.getValue();
        //System.out.println(output);
        textView.setText(output);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        textViewExtra.setText(name);
    }
}
