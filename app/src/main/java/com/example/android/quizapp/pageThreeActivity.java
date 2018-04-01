package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import static com.example.android.quizapp.pageOneActivity.df;
import static com.example.android.quizapp.pageOneActivity.POINTS_PER_QUESTION;


public class pageThreeActivity extends AppCompatActivity {
    int pow3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_three_activity);
    }

    /**if user clicks any incorrect answer a Toast is printed and he is take to the incorrect answer page through an Intent.**/
    public void incorrectAnswer3(View view){
        Intent page_3_incorrect_answer = new Intent(pageThreeActivity.this, pageThreeIncorrectAnswer.class);
        startActivity(page_3_incorrect_answer);
        Toast.makeText(getApplicationContext(), "You are incorrect!", Toast.LENGTH_LONG).show();
        pow3=-1;
    }

    /**pow gets its value from the previous activity;
     * pow is incremented;
     * finalScore is calculated;
     * pow is sent forward through an Intent;
     * two Toasts are printed on the screen: one with the score and one with a correct message;
     * user is taken to the next activity.**/
    public void correctAnswer3 (View view){
        pow3 = getIntent().getIntExtra("pow2",0);
        pow3++;
        String finalScore3=df.format(Math.pow(2,pow3)*POINTS_PER_QUESTION);
        Intent page_3_correct_answer = new Intent (pageThreeActivity.this, pageFourActivity.class);
        page_3_correct_answer.putExtra("pow3", pow3);
        startActivity(page_3_correct_answer);
        Toast.makeText(getApplicationContext(), "You are correct!", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "So far you have "+ finalScore3 + " points.", Toast.LENGTH_LONG).show();
    }
}