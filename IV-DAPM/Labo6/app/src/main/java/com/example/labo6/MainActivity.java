package com.example.labo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MySharedPreference mySharedPreference;
    EditText editText;
    Button buttonSave;
    Button buttonGoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySharedPreference = new MySharedPreference(MainActivity.this);
        editText = findViewById(R.id.editText);
        buttonSave = findViewById(R.id.buttonSave);
        buttonGoto = findViewById(R.id.buttonGoto);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String preference = editText.getText().toString();
                mySharedPreference.save(preference);
               // System.out.println(preference);
            }
        });
    }

    public void SecondActivity (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", "Text to pass in the second activity");
        startActivity(intent);
    }
}
