package com.example.android.quizapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.android.quizapp.pageOneActivity.POINTS_PER_QUESTION;
import static com.example.android.quizapp.pageOneActivity.df;

public class pageSixCorrectAnswer extends AppCompatActivity {
    //  Score value is initialized as "firstScore" and cast to string
//  The onCreate method initializes the value of the "question_6_score" TextView with the score value
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_six_correct_answer);
    }

    /**this calculates the final score**/
    public void getScore (View view){
        int powFinal = getIntent().getIntExtra("pow6", 0);
        String finalScore6 = df.format(Math.pow(2,powFinal)*POINTS_PER_QUESTION);;
        TextView question_6_score = (TextView)findViewById(R.id.final_score);
        question_6_score.setText(finalScore6);
        Toast.makeText(getApplicationContext(), "Your score is"+ finalScore6, Toast.LENGTH_LONG);
    }
    /**closes the app**/
    public void close (View view){
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

}