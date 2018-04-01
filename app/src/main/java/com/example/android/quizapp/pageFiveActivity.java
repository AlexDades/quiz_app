package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import static com.example.android.quizapp.pageOneActivity.df;
import static com.example.android.quizapp.pageOneActivity.POINTS_PER_QUESTION;

/** count - keeps track if the user chose the correct combination of options;
 *  CheckBox initializes the 4 checkboxes: checkBoxA, checkBoxB, checkBoxC, checkBoxD.**/
public class pageFiveActivity extends AppCompatActivity implements View.OnClickListener {
    public int count = 0;
    CheckBox checkBoxA, checkBoxB, checkBoxC, checkBoxD;
    int pow5;

    /** a onClickListener is set on each checkbox: checkBoxA, checkBoxB, checkBoxC, checkBoxD. **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_five_activity);
        checkBoxA = findViewById(R.id.checkbox_A);
        checkBoxA.setOnClickListener(this);
        checkBoxB = findViewById(R.id.checkbox_B);
        checkBoxB.setOnClickListener(this);
        checkBoxC = findViewById(R.id.checkbox_C);
        checkBoxC.setOnClickListener(this);
        checkBoxD = findViewById(R.id.checkbox_D);
        checkBoxD.setOnClickListener(this);
    }
    /** if checkBoxA and checkBoxC are checked, count is incremented to 1;
     * if any other combination of checkboxes is checked, count remains 0.**/
    @Override
    public void onClick(View view) {

         if (checkBoxB.isChecked() && checkBoxD.isChecked() && checkBoxA.isChecked()){
            count=0;
        }
        else if (checkBoxC.isChecked() && checkBoxB.isChecked() && checkBoxA.isChecked()){
            count=0;
        }
        else if (checkBoxC.isChecked() && checkBoxD.isChecked() && checkBoxA.isChecked()){
            count=0;
        }
         else if (checkBoxC.isChecked() && checkBoxD.isChecked() && checkBoxB.isChecked()){
             count=0;
         }
        else if (checkBoxD.isChecked()&& checkBoxA.isChecked() && checkBoxC.isChecked() && checkBoxB.isChecked()){
            count=0;
        }
        else if (checkBoxB.isChecked()&& checkBoxA.isChecked()){
            count=0;
        }
         else if (checkBoxD.isChecked()&& checkBoxA.isChecked()){
             count=0;
         }
        else if (checkBoxC.isChecked()&& checkBoxD.isChecked()){
            count=0;
        }
         else if (checkBoxB.isChecked()&& checkBoxD.isChecked()){
             count=0;
         }
         else if (checkBoxC.isChecked()&& checkBoxB.isChecked()){
             count=0;
         }
         else if (checkBoxC.isChecked()&& checkBoxA.isChecked()){
             count=1;
         }
    }

    /**this method is called whenever the Submit button is clicked;
     * method checks the value of count.:
     * If count == 1, pow6 is declared and initialized with the value of pow4 through an Intent;
     *      pow6 is incremented;
     *      the finalScore value is calculated as 2 to the power of pow6, the value is multiplied by POINTS_PER_QUESTION and the end result is formatted to get rid of the decimal value;
     *      the value of pow6 is then passed forward through an intent;
     *      the method then creates a Toast with the score and one with a message;
     * If count ==0, the method creates a Toast to say so and sends the user to the incorrect page activity.**/
    public void submit(View view) {
        if (count == 1) {
            pow5 = getIntent().getIntExtra("pow4", 0);
            pow5++;
            String finalScore5 = df.format(Math.pow(2,pow5)*POINTS_PER_QUESTION);
            Intent page_5_correct_answer = new Intent(getApplicationContext(), pageSixActivity.class);
            page_5_correct_answer.putExtra("pow5", pow5);
            startActivity(page_5_correct_answer);
            Toast.makeText(getApplicationContext(), "You are correct!", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "So far you have "+ finalScore5 + " points.", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "You are incorrect!",
                    Toast.LENGTH_LONG).show();
            Intent page_five_incorrect_answer = new Intent(getApplicationContext(), pageFiveIncorrectAnswer.class);
            startActivity(page_five_incorrect_answer);
            pow5=-1;
        }
    }
}