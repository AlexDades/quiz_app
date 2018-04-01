package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quizapp.pageOneActivity.df;
import static com.example.android.quizapp.pageOneActivity.POINTS_PER_QUESTION;

/** count will be incremented if the correct answer was pressed;**/
public class pageSixActivity extends AppCompatActivity implements View.OnClickListener {
    int count = 0;
    RadioButton radioButtonA, radioButtonB, radioButtonC;
    int pow6;



    /**radioButtonA, radioButtonB, radioButtonC are initialized an onClickListeners are set on them**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_six_activity);
        radioButtonA = findViewById(R.id.radio_A);
        radioButtonA.setOnClickListener(this);
        radioButtonB = findViewById(R.id.radio_B);
        radioButtonB.setOnClickListener(this);
        radioButtonC = findViewById(R.id.radio_C);
        radioButtonC.setOnClickListener(this);
    }

    /**if the correct answer is checked count becomes 1**/
    @Override
    public void onClick(View view) {
        if (radioButtonA.isChecked()){
            count=1;
        }
        else if (radioButtonB.isChecked()){
            count=0;
        }
        else if (radioButtonC.isChecked()){
            count=0;
        }
    }

    /** if value of count is 1, this means that the user picked the correct answer and the score values is calculated
   If value of count is 0, this means that the user picked one of the 2 wrong answers, score is reset and the game is set back to the starting screen.**/
    public void submit(View view) {
        if (count == 1) {
            pow6 = getIntent().getIntExtra("pow5", 0);
            pow6++;
            String finalScore6 = df.format(Math.pow(2,pow6)*POINTS_PER_QUESTION);
            Intent page_6_correct_answer= new Intent(getApplicationContext(), pageSixCorrectAnswer.class);
            page_6_correct_answer.putExtra("finalScore6", finalScore6);
            page_6_correct_answer.putExtra("pow6", pow6);
            startActivity(page_6_correct_answer);
            Toast.makeText(getApplicationContext(), "You are correct!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "You are incorrect!",
                    Toast.LENGTH_LONG).show();
            Intent page_five_incorrect_answer = new Intent(getApplicationContext(), pageSixIncorrectAnswer.class);
            startActivity(page_five_incorrect_answer);
            pow6=-1;
        }
    }
}