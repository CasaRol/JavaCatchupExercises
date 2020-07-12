package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LocalGameActivity extends AppCompatActivity {

    GameLogic gameLogic;

    private Button newGame;
    private TextView playerID;
    private TextView textview;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;
    private TextView textview6;
    private TextView textview7;
    private TextView textview8;
    private TextView winner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_game);

        playerID = findViewById(R.id.playerID);
        newGame = findViewById(R.id.newGame);

        textview = findViewById(R.id.place0);
        textview1 = findViewById(R.id.place1);
        textview2 = findViewById(R.id.place2);
        textview3 = findViewById(R.id.place3);
        textview4 = findViewById(R.id.place4);
        textview5 = findViewById(R.id.place5);
        textview6 = findViewById(R.id.place6);
        textview7 = findViewById(R.id.place7);
        textview8 = findViewById(R.id.place8);

        winner = findViewById(R.id.winnerLabel);

        gameLogic = new GameLogic();
        playerID.setText(gameLogic.getPlayer());

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(0) == null) {
                    move(0, textview);
                }
            }
        });

        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(1) == null) {
                    move(1, textview1);
                }
            }
        });

        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(2) == null) {
                    move(2, textview2);
                }
            }
        });

        textview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(3) == null) {
                    move(3, textview3);
                }
            }
        });

        textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(4) == null) {
                    move(4, textview4);
                }
            }
        });

        textview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(5) == null) {
                    move(5, textview5);
                }
            }
        });

        textview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(6) == null) {
                    move(6, textview6);
                }
            }
        });

        textview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(7) == null) {
                    move(7, textview7);
                }
            }
        });

        textview8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameLogic.getGameboardIndex(8) == null) {
                    move(8, textview8);
                }
            }
        });
    }

    private void move(int index, TextView originalView) {
        originalView.setText(gameLogic.getPlayer());
        gameLogic.playerMove(index, gameLogic.getPlayer());
        playerID.setText(gameLogic.getPlayer());

         if(gameLogic.checkWin() == "draw") {
            winner.setText("Game is a Draw...");
        } else if(gameLogic.checkWin() != "-1") {
            winner.setText(gameLogic.checkWin() + " Wins this wound");
        }
    }

    private void newGame() {
        //resetting game
        gameLogic = new GameLogic();
        playerID.setText(gameLogic.getPlayer());

        textview.setText("");
        textview1.setText("");
        textview2.setText("");
        textview3.setText("");
        textview4.setText("");
        textview5.setText("");
        textview6.setText("");
        textview7.setText("");
        textview8.setText("");
        winner.setText("");
    }


}