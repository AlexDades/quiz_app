package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;

/** pow keeps count of the number of correctly answered questions. It is initialized with -1 because it will be a power of 2;
 * finalScore will always display the current score
 * df is used to get the value without the devimal number;
 * POINTS_PER_QUESTION is used to multiply the number of correct answers by 100.**/
public class pageOneActivity extends AppCompatActivity {
    //    Ths score is kept in value "pow".
    public static int pow1 = -1;
    public static String finalScore1;
    public static DecimalFormat df = new DecimalFormat("###.#");
    public static final int POINTS_PER_QUESTION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_one_activity);
    }

    /** this method takes the user back to the first activity and prints out a Toast**/
    public void incorrectAnswer1(View view) {
        Intent page_1_incorrect_answer = new Intent(pageOneActivity.this, pageOneIncorrectAnswer.class);
        startActivity(page_1_incorrect_answer);
        pow1=-1;
        Toast.makeText(getApplicationContext(), "You are incorrect!", Toast.LENGTH_LONG).show();
    }

    /** pow is incremented;
     *  finalScore stores the score value;
     *  pow is sent forward through an Intent;
     *  two Toast messages are printed.**/
    public void correctAnswer1(View view) {
        pow1++;
        finalScore1 = df.format(Math.pow(2, pow1) * POINTS_PER_QUESTION);
        Intent page_1_correct_answer = new Intent(pageOneActivity.this, pageTwoActivity.class);
        page_1_correct_answer.putExtra("pow1", pow1);
        startActivity(page_1_correct_answer);
        Toast.makeText(getApplicationContext(), "You are correct!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "So far you have " + finalScore1 + " points.", Toast.LENGTH_LONG).show();

    }

}