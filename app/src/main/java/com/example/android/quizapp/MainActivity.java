package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.android.quizapp.pageOneActivity.pow1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
    /** Starts the game and launches the first question
     *  This is done through an Intent to pageOneActivity.class.**/
    public void start(View view) {
        Intent startGame = new Intent(MainActivity.this, pageOneActivity.class);
        startActivity(startGame);
        pow1=-1;

    }
}





