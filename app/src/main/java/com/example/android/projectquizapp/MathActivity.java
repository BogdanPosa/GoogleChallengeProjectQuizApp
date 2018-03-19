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


    /**
     * This method opens the main activity
     */
    public Button backbut;
    LinearLayout Q5, Q6, Q7, Q8;
    RadioGroup rgQ6, rgQ8;
    /**
     * This method calculates the score for this activity
     */

    int score = 0;
    String Scor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        goBack();
        showImage();

        Q5 = findViewById(R.id.LLQ5);
        Q6 = findViewById(R.id.LLQ6);
        Q7 = findViewById(R.id.LLQ7);
        Q8 = findViewById(R.id.LLQ8);

        Q6.setVisibility(View.GONE);
        Q7.setVisibility(View.GONE);
        Q8.setVisibility(View.GONE);
    }

    /**
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

    /**
     * This method display the Question 6 and makes the Question 5 disappear
     */

    public void subQ5Clicked(View v) {
        calculateScore();

        Q5.setVisibility(View.GONE);
        Q6.setVisibility(View.VISIBLE);
    }

    /**
     * This method display the Question 7 and makes the Question 6 disappear
     */

    public void subQ6Clicked(View v) {
        calculateScore();

        Q6.setVisibility(View.GONE);
        Q7.setVisibility(View.VISIBLE);
    }

    /**
     * This method display the Question 8 and makes the Question 7 disappear
     */
    public void subQ7Clicked(View v) {
        calculateScore();

        Q7.setVisibility(View.GONE);
        Q8.setVisibility(View.VISIBLE);
    }

    /**
     * This method starts the result activity
     */

    public void subQ8Clicked(View v) {
        calculateScore();
        //     showProgress();

        Q7.setVisibility(View.GONE);
        Context context = getApplicationContext();
        CharSequence text = "Your got: " + score + "%";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent ResultActivity = new Intent(MathActivity.this, ResultActivity.class);
        ResultActivity.putExtra("scor", Scor);
        startActivity(ResultActivity);

    }

    public void calculateScore() {

        Button butsub1 = findViewById(R.id.submit1);
        boolean but1Pressed = butsub1.isPressed();
        Button butsub2 = findViewById(R.id.submit2);
        boolean but2Pressed = butsub2.isPressed();
        Button butsub3 = findViewById(R.id.submit3);
        boolean but3Pressed = butsub3.isPressed();
        Button butsub4 = findViewById(R.id.submit4);
        boolean but4Pressed = butsub4.isPressed();

        CheckBox Q7Answer1 = findViewById(R.id.Q7RightAnswer1);
        boolean CorrectAnswer1 = Q7Answer1.isChecked();
        CheckBox Q7Answer3 = findViewById(R.id.Q7RightAnswer3);
        boolean CorrectAnswer3 = Q7Answer3.isChecked();

        rgQ6 = findViewById(R.id.rgQuestion6);
        rgQ8 = findViewById(R.id.rgQuestion8);

        int checkedRadioButtonId = rgQ6.getCheckedRadioButtonId();
        int checkedRadioButton2Id = rgQ8.getCheckedRadioButtonId();


        EditText str = findViewById(R.id.text_input);
        String test = str.getText().toString();


        if (test.equals("1.2") && but1Pressed) {
            score = score + 25;
        } else {
            if (checkedRadioButtonId == R.id.rb3Answer6 && but2Pressed) {
                score = score + 25;
            } else {
                if (CorrectAnswer1 && CorrectAnswer3 && but3Pressed) {

                    score = score + 25;
                } else {
                    if (checkedRadioButton2Id == R.id.rb3Answer8 && but4Pressed) {
                        score = score + 25;
                    }
                }
            }
        }
        showImage();
    }

    /**
     * This method changes the image shown based on the score
     */
    public void showImage() {
        ImageView progressImage = findViewById(R.id.progressimage);
        if (score == 0) {
            Scor = "Your score is:\n" + score + "%";
            progressImage.setImageResource(R.drawable.image04);

        } else {
            if (score == 25) {
                Scor = "Your score is:\n" + score + "%";
                progressImage.setImageResource(R.drawable.image14);
            } else {
                if (score == 50) {
                    Scor = "Your score is:\n" + score + "%";
                    progressImage.setImageResource(R.drawable.image24);
                } else {
                    if (score == 75) {
                        Scor = "Your score is:\n" + score + "%";
                        progressImage.setImageResource(R.drawable.image34);
                    } else {
                        if (score == 100) {
                            Scor = "Your score is:\n" + score + "%";
                            progressImage.setImageResource(R.drawable.image44);
                        }
                    }
                }
            }
        }
    }

    public void goBack() {
        backbut = findViewById(R.id.back);
        backbut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent MainActivity = new Intent(MathActivity.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }

}
