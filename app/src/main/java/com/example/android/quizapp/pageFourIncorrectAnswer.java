package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pageFourIncorrectAnswer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_four_incorrect_answer);
    }
    /** the reset method takes the user back to the first activity**/
    public void reset (View view){
        Intent reset = new Intent(pageFourIncorrectAnswer.this, MainActivity.class);
        startActivity(reset);
    }
}