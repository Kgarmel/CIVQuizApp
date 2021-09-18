package com.example.android.civquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score=0;

    public void submitAnswers(View view) {
        EditText nameField = findViewById(R.id.et_name_field);
        String name = nameField.getText().toString();

        // Check which radio button was clicked and find the score of the question1RadioGroup and store it in a variable
        RadioButton question1Answers2 = findViewById(R.id.rb_question1Answers2);
        boolean hasQuestion1Answers2 = question1Answers2.isChecked();

        // Check which radio button was clicked and find the score of the question1RadioGroup and store it in a variable
        RadioButton question2Answers3 = findViewById(R.id.rb_question2Answers3);
        boolean hasQuestion2Answers3 = question2Answers3.isChecked();

        // Check which radio button was clicked and find the score of the question1RadioGroup and store it in a variable
        RadioButton question3Answers1 = findViewById(R.id.rb_question3Answers1);
        boolean hasQuestion3Answers1 = question3Answers1.isChecked();

        // Check which radio button was clicked and find the score of the question1RadioGroup and store it in a variable
        RadioButton question4Answers2 = findViewById(R.id.rb_question4Answers2);
        boolean hasQuestion4Answers2 = question4Answers2.isChecked();

        //find the score of the question5CheckBox2 and store it in a variable
        CheckBox question5Answers1 = findViewById(R.id.cb_question5Answers1);
        boolean hasQuestion5Answers1 = question5Answers1.isChecked();

        //find the score of the question5CheckBox2 and store it in a variable
        CheckBox question5Answers2 = findViewById(R.id.cb_question5Answers2);
        boolean hasQuestion5Answers2 = question5Answers2.isChecked();

        //find the score of the question5CheckBox2 and store it in a variable
        CheckBox question5Answers3 = findViewById(R.id.cb_question5Answers3);
        boolean hasQuestion5Answers3 = question5Answers3.isChecked();

        //find the score of the question6 and store it in a variable
        EditText questionField = findViewById(R.id.et_question_field);
        String response =  questionField.getText().toString().trim();
        boolean hasUserAns = Boolean.getBoolean(String.valueOf("Attiéké".equalsIgnoreCase(response)));

        
        // Calculate the score
        int sumScore = calculateScore(hasQuestion1Answers2, hasQuestion2Answers3, hasQuestion3Answers1, hasQuestion4Answers2, hasQuestion5Answers1, hasQuestion5Answers2, hasQuestion5Answers3, hasUserAns);

        // Display the score summary on the screen
        String scoreMessage = "Name: " + name;
        scoreMessage += "\nTotal Score:" + sumScore + " out of 7";
        scoreMessage += "\nThank you!";
        Toast.makeText(this, "Quiz Score_" + scoreMessage, Toast.LENGTH_SHORT).show();

        if (sumScore >= 6) {
            Toast.makeText(this, "Great Job!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Keep Learning, Cheers!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Calculate the total score
     * @return total score
     */
    public int calculateScore(boolean hasQuestion1Answers2, boolean hasQuestion2Answers3, boolean hasQuestion3Answers1, boolean hasQuestion4Answers2, boolean hasQuestion5Answers1, boolean hasQuestion5Answers2, boolean hasQuestion5Answers3, boolean hasUserAns) {

        int sumScore = score;

        // Add 1 if the user select hasQuestion1Answers2
        if (hasQuestion1Answers2) {
            sumScore++;
        }

        // Add 1 if the user select hasQuestion2Answers3
        if (hasQuestion2Answers3) {
            sumScore++;
        }

        // Add 1 if the user select hasQuestion3Answers1
        if (hasQuestion3Answers1) {
            sumScore++;
        }

        // Add 1 if the user select hasQuestion4Answers2
        if (hasQuestion4Answers2) {
            sumScore++;
        }

        // Add 1 if the user select hasQuestion5Answers1
        if (hasQuestion5Answers1) {
            sumScore++;
        }

        // Add 1 if the user select hasQuestion5Answers2
        if ( hasQuestion5Answers2) {
            sumScore++;
        }

        // Add 1 if the user select hasQuestion5Answers3
        if (hasQuestion5Answers3 ) {
            sumScore--;
        }

        // Add 1 if the user select question6
        if (hasUserAns) {
            sumScore++;
        }

        //Calculate total score
        return sumScore;
    }

}

