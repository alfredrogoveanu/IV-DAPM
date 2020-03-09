package com.example.labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login1 (View v) {
        String username = ((EditText)findViewById(R.id.editText)).getText().toString();
        String password = ((EditText)findViewById(R.id.editText2)).getText().toString();
        /*if (username.equals("student")) {
            Log.w("TAG", "u ok!");
        }
        if (password.equals("student")) {
            Log.w("TAG", "pw ok!");
        }*/
        if (username.equals("student") && password.equals("student")) {
            Intent i = new Intent(this, FindTheNumberActivity.class);
            startActivity(i);
        } else {
          //  Log.w("TAG", "username: " + username + " , pw: " + password);
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show();
        }
    }

}
