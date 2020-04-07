package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare member variables here:
    private Button trueButton;
    private Button falseButton;
    private TextView questionTextView;
    private int index;
    private int question;
    private TextView scoreView;
    private ProgressBar progressBar;
    private int score;

    // TODO: Uncomment to create question bank
    private TrueFalse[] questionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true)
    };

    // TODO: Declare constants here
    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.question_text_view);
        scoreView = findViewById(R.id.score);
        progressBar = findViewById(R.id.progress_bar);

        question = questionBank[index].getQuestionID();
        questionTextView.setText(question);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateScore();
                updateQuestion();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateScore();
                updateQuestion();
            }
        });

    }

    private void updateQuestion() {
        index = (index + 1) % questionBank.length;

        if (index == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over!");
            alert.setCancelable(false);
            alert.setMessage("You scored " + score + " points.");
            alert.setPositiveButton("Close application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        question = questionBank[index].getQuestionID();
        questionTextView.setText(question);
        progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        scoreView.setText("Score " + score + "/" + questionBank.length);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questionBank[index].getAnswer();

        if (userAnswer == correctAnswer) {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateScore() {

    }
}
