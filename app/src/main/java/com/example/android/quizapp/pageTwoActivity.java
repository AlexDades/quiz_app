package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.android.quizapp.pageOneActivity.df;
import static com.example.android.quizapp.pageOneActivity.POINTS_PER_QUESTION;


public class pageTwoActivity extends AppCompatActivity {
int pow2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_two_activity);

    }
    /**if user clicks any incorrect answer a Toast is printed and he is take to the incorrect answer page through an Intent.**/
    public void incorrectAnswer2(View view){
        Intent page_2_incorrect_answer = new Intent(pageTwoActivity.this, pageTwoIncorrectAnswer.class);
        startActivity(page_2_incorrect_answer);
        Toast.makeText(getApplicationContext(), "You are incorrect!", Toast.LENGTH_LONG).show();
        pow2 = -1;
    }
    /**pow gets its value from the previous activity;
     * pow is incremented;
     * finalScore is calculated;
     * pow is sent forward through an Intent;
     * two Toasts are printed on the screen: one with the score and one with a correct message;
     * user is taken to the next activity.**/
    public void correctAnswer2 (View view){
        pow2 = getIntent().getIntExtra("pow1",0);
        pow2++;
        String finalScore2=df.format(Math.pow(2,pow2)*POINTS_PER_QUESTION);
        Intent page_2_correct_answer = new Intent (pageTwoActivity.this, pageThreeActivity.class);
        page_2_correct_answer.putExtra("pow2", pow2);
        startActivity(page_2_correct_answer);
        Toast.makeText(getApplicationContext(), "You are correct!", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "So far you have "+ finalScore2 + " points.", Toast.LENGTH_LONG).show();
    }

}