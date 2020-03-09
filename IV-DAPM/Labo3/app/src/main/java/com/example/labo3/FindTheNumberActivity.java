package com.example.labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class FindTheNumberActivity extends AppCompatActivity {

    Random rand = new Random();
    int randomNr = rand.nextInt(11);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_number);
        final Button button1 = (Button)findViewById(R.id.button2);
        button1.setBackgroundColor(Color.RED);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = 0;
                Drawable bck = button1.getBackground();
                if (bck instanceof ColorDrawable) {
                    color = ((ColorDrawable)bck).getColor();
                }

                if (color == Color.RED) {
                    button1.setBackgroundColor(Color.BLUE);
                } else {
                    button1.setBackgroundColor(Color.RED);
                }

                int guessed;
                String guessed0 = ((EditText)findViewById(R.id.editText3)).getText().toString();
                if (guessed0.equals("")) {

                } else
                {
                    guessed = Integer.parseInt(((EditText)findViewById(R.id.editText3)).getText().toString());
                    if (guessed < randomNr) {
                        Toast.makeText(FindTheNumberActivity.this, "Lower", Toast.LENGTH_LONG).show();
                    }
                    if (guessed > randomNr) {
                        Toast.makeText(FindTheNumberActivity.this, "Higher", Toast.LENGTH_LONG).show();
                    }
                    if (guessed == randomNr) {
                        Toast.makeText(FindTheNumberActivity.this, "You won! Try again", Toast.LENGTH_LONG).show();
                        rand = new Random();
                        randomNr = rand.nextInt(11);
                    }
                }
            }
        });
    }

    public void Guess (View v) {

        //button1.setBackgroundColor(Color.parseColor("#F0F0F0"));




    }
}
