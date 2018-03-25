package com.example.android.projectquizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MathActivity extends AppCompatActivity {

    public Button homeButton;
    public Button submitButton1;
    public Button submitButton2;
    public Button submitButton3;
    public Button submitButton4;
    public EditText str;
    String ScoreMessage;
    boolean button1Pressed;
    boolean button2Pressed;
    boolean button3Pressed;
    boolean button4Pressed;
    boolean correctAnswer1;
    boolean correctAnswer3;
    boolean wrongAnswer1;
    boolean wrongAnswer2;
    private LinearLayout layoutQ5;
    private LinearLayout layoutQ6;
    private LinearLayout layoutQ7;
    private LinearLayout layoutQ8;
    private RadioGroup rgQ6;
    private RadioGroup rgQ8;
    private int score = 0;
    private String Scor;
    private CheckBox Q7Answer1;
    private CheckBox Q7Answer3;
    private CheckBox Q7Answer2;
    private CheckBox Q7Answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        goHome();
        showImage();

        submitButton1 = findViewById(R.id.submit1);
        submitButton2 = findViewById(R.id.submit2);
        submitButton3 = findViewById(R.id.submit3);
        submitButton4 = findViewById(R.id.submit4);
        str = findViewById(R.id.text_input);
        Q7Answer1 = findViewById(R.id.Q7RightAnswer1);
        Q7Answer3 = findViewById(R.id.Q7RightAnswer3);
        Q7Answer2 = findViewById(R.id.Q7WrongAnswer1);
        Q7Answer4 = findViewById(R.id.Q7WrongAnswer2);
        rgQ6 = findViewById(R.id.rgQuestion6);
        rgQ8 = findViewById(R.id.rgQuestion8);
        layoutQ5 = findViewById(R.id.LLQ5);
        layoutQ6 = findViewById(R.id.LLQ6);
        layoutQ7 = findViewById(R.id.LLQ7);
        layoutQ8 = findViewById(R.id.LLQ8);

        ScoreMessage = getString(R.string.scoreMessage);
        layoutQ6.setVisibility(View.GONE);
        layoutQ7.setVisibility(View.GONE);
        layoutQ8.setVisibility(View.GONE);
    }

    /*
     * This method makes the keyboard disappear when clicking outside
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    /*
     * This method display the Question 6 and makes the Question 5 disappear
     */

    public void subQ5Clicked(View v) {
        calculateScore();

        layoutQ5.setVisibility(View.GONE);
        layoutQ6.setVisibility(View.VISIBLE);
    }

    /*
     * This method display the Question 7 and makes the Question 6 disappear
     */

    public void subQ6Clicked(View v) {
        calculateScore();

        layoutQ6.setVisibility(View.GONE);
        layoutQ7.setVisibility(View.VISIBLE);
    }

    /*
     * This method display the Question 8 and makes the Question 7 disappear
     */
    public void subQ7Clicked(View v) {
        calculateScore();

        layoutQ7.setVisibility(View.GONE);
        layoutQ8.setVisibility(View.VISIBLE);
    }

    /*
     * This method starts the result activity
     */

    public void subQ8Clicked(View v) {
        calculateScore();

        layoutQ7.setVisibility(View.GONE);
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.mathInfo) + score + "%";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent ResultActivity = new Intent(MathActivity.this, ResultActivity.class);
        ResultActivity.putExtra("score", Scor);
        startActivity(ResultActivity);

    }

    public void calculateScore() {

        button1Pressed = submitButton1.isPressed();
        button2Pressed = submitButton2.isPressed();
        button3Pressed = submitButton3.isPressed();
        button4Pressed = submitButton4.isPressed();
        correctAnswer1 = Q7Answer1.isChecked();
        correctAnswer3 = Q7Answer3.isChecked();
        wrongAnswer1 = Q7Answer2.isChecked();
        wrongAnswer2 = Q7Answer4.isChecked();

        int checkedRadioButtonId = rgQ6.getCheckedRadioButtonId();
        int checkedRadioButton2Id = rgQ8.getCheckedRadioButtonId();

        String test = str.getText().toString();

        if (test.equals("1.2") && button1Pressed) {
            score = score + 25;
        }
        if (checkedRadioButtonId == R.id.rb3Answer6 && button2Pressed) {
            score = score + 25;
        }

        if (correctAnswer1 && correctAnswer3 && !wrongAnswer1 && !wrongAnswer2 && button3Pressed) {
            score = score + 25;
        }

        if (checkedRadioButton2Id == R.id.rb3Answer8 && button4Pressed) {
            score = score + 25;
        }
        showImage();
    }

    /*
     * This method changes the image shown based on the score
     */
    public void showImage() {
        ImageView progressImage = findViewById(R.id.progressImage);
        if (score == 0) {
            Scor = ScoreMessage + score + "%";
            progressImage.setImageResource(R.drawable.image04);

        } else {
            if (score == 25) {
                Scor = ScoreMessage + score + "%";
                progressImage.setImageResource(R.drawable.image14);
            } else {
                if (score == 50) {
                    Scor = ScoreMessage + score + "%";
                    progressImage.setImageResource(R.drawable.image24);
                } else {
                    if (score == 75) {
                        Scor = ScoreMessage + score + "%";
                        progressImage.setImageResource(R.drawable.image34);
                    } else {
                        if (score == 100) {
                            Scor = ScoreMessage + score + "%";
                            progressImage.setImageResource(R.drawable.image44);
                        }
                    }
                }
            }
        }
    }

    public void goHome() {
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent MainActivity = new Intent(MathActivity.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }
}
