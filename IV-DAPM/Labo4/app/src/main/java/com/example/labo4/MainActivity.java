package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int activePlayer = 0;
    boolean gameIsActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        // get the current Image View (counter tag)
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //if the space is empty(is 2) and the game is not over
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            //set the current player
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                // setImageResource for counter as x
                // TODO
                counter.setImageResource(R.drawable.lab4_x);

                // change the player's turn
                activePlayer = 1;
            } else {
                // setImageResource for counter as zero
                // TODO
                counter.setImageResource(R.drawable.lab4_zero);

                activePlayer = 0;
            }
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    // Someone has won!
                    gameIsActive = false;
                    String winner = "Player1 -> 0";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Player2 -> x";
                    }
                    // Make a toast with the messaje winner + " has won!"
                    //TODO
                    LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout1);
                    ll.setVisibility(view.VISIBLE);
                    TextView tw = (TextView) findViewById(R.id.textView1);
                    if (winner == "Player1 -> 0") {
                        tw.setText("Player 1 has won!");
                        //Toast.makeText(this, "Player 1 has won!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        tw.setText("Player 2 has won!");
                       // Toast.makeText(this, "Player 2 has won!", Toast.LENGTH_LONG).show();
                    }

                } else {
                    boolean gameIsOver = true;

                    for (int counterState : gameState) {
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver) {
                        // Make a toast with the messaje "It's a draw!"
                        //TODO
                        Toast.makeText(this, "It's a draw!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

    }

    public void playAgain(View view) {

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout1);
        ll.setVisibility(view.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

        activePlayer = 0;
        gameIsActive = true;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

    }
}
