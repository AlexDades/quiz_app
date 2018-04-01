package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.android.quizapp.pageOneActivity.df;
import static com.example.android.quizapp.pageOneActivity.POINTS_PER_QUESTION;

/** correctAnswer4, correctAnswer4Complete1 and correctAnswer4Complete2 are possible answers that the user can type in and are used to be compared to the correct answer**/
public class pageFourActivity extends AppCompatActivity {
    final String correctAnswer4 = "99";
    final String correctAnswer4Complete1 = "99 units";
    final String correctAnswer4Complete2 = "99units";
    int pow4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_four_activity);
    }

    /**the value of pow4 is initialized through an intent;
     * the value typed in is store in answer, which is then transformed into a String variable;
     * if result variable is equal to any of the 3 string variables initialized at the top of the class:
     *      pow4 is incremented;
     *      its value is passed forward through an Intent;
     *      the method creates two toasta: the score and a "correct" message;
     * else a Toast message is created to state that the answer is incorrect;
     *      the user is taken to the incorrect answer activity**/
    public void submit (View view){
        String finalScore4;
        pow4 = getIntent().getIntExtra("pow3",0);
        final EditText answer = (EditText)findViewById(R.id.question_four_edit_text);
        String result = answer.getText().toString();
        if((result.equals(correctAnswer4)|| result.equals(correctAnswer4Complete1) || result.equals(correctAnswer4Complete2))){
            pow4++;
            finalScore4=df.format(Math.pow(2,pow4)*POINTS_PER_QUESTION);
            Intent page_4_correct_answer = new Intent(getApplicationContext(), pageFiveActivity.class);
            page_4_correct_answer.putExtra("pow4", pow4);
            startActivity(page_4_correct_answer);
            Toast.makeText(getApplicationContext(), "You are correct!",Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "So far you have "+ finalScore4 + " points.", Toast.LENGTH_LONG).show();
        }
        else {Toast.makeText(getApplicationContext(), "You are incorrect!",
                Toast.LENGTH_LONG).show();
        Intent incorrect_answer_4 = new Intent(getApplicationContext(), pageFourIncorrectAnswer.class);
        startActivity(incorrect_answer_4);
        pow4=-1;

        }
    }
}