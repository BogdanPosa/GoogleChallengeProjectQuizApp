package com.example.android.projectquizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class VocabularyActivity extends AppCompatActivity {

    /**
     * This method takes it back to the main page
     */
    public Button backBut1;
    public Button submit1;
    String ScoreMessage;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    int score;
    String Scor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        goBack1();
        submit1();

        radioGroup1 = findViewById(R.id.rgQuestion1);
        radioGroup2 = findViewById(R.id.rgQuestion2);
        radioGroup3 = findViewById(R.id.rgQuestion3);
        radioGroup4 = findViewById(R.id.rgQuestion4);

        ScoreMessage = getString(R.string.scoreMessage);
    }

    public void goBack1() {
        backBut1 = findViewById(R.id.back1);
        backBut1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent MainActivity = new Intent(VocabularyActivity.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }

    /**
     * This method calculates and submits the score for this subject
     */
    public void submit1() {
        submit1 = findViewById(R.id.submit1);
        submit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                int checkedRadioButtonId = radioGroup1.getCheckedRadioButtonId();
                int checkedRadioButton2Id = radioGroup2.getCheckedRadioButtonId();
                int checkedRadioButton3Id = radioGroup3.getCheckedRadioButtonId();
                int checkedRadioButton4Id = radioGroup4.getCheckedRadioButtonId();


                if (checkedRadioButtonId == R.id.rb1Answer1) {
                    score = score + 25;
                }
                if (checkedRadioButton2Id == R.id.rb2Answer2) {
                    score = score + 25;
                }
                if (checkedRadioButton3Id == R.id.rb3Answer4) {
                    score = score + 25;
                }
                if (checkedRadioButton4Id == R.id.rb4Answer2) {
                    score = score + 25;
                }

                if (checkedRadioButtonId == -1) {
                    // No item selected Answer 1

                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.toastQ1);
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if (checkedRadioButton2Id == -1) {
                        // No item selected Answer 2

                        Context context = getApplicationContext();
                        CharSequence text = getString(R.string.toastQ2);
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        if (checkedRadioButton3Id == -1) {
                            // No item selected Answer 3

                            Context context = getApplicationContext();
                            CharSequence text = getString(R.string.toastQ3);
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {

                            if (checkedRadioButton4Id == -1) {
                                // No item selected Answer 4

                                Context context = getApplicationContext();
                                CharSequence text = getString(R.string.toastQ4);
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                if (score == 0) {
                                    Scor = ScoreMessage + score + "%";

                                } else {
                                    if (score == 25) {
                                        Scor = ScoreMessage + score + "%";
                                    } else {
                                        if (score == 50) {
                                            Scor = ScoreMessage + score + "%";
                                        } else {
                                            if (score == 75) {
                                                Scor = ScoreMessage + score + "%";
                                            } else {
                                                if (score == 100) {
                                                    Scor = ScoreMessage + score + "%";
                                                }
                                            }
                                        }
                                    }
                                }
                                Intent ResultActivity = new Intent(VocabularyActivity.this, ResultActivity.class);
                                ResultActivity.putExtra("score", Scor);

                                startActivity(ResultActivity);
                            }
                        }
                    }
                }
            }
        });
    }
}
