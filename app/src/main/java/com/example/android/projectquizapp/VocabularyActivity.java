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
    public Button backbut1;
    public Button submit1;
    int score;
    String Scor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        goBack1();
        submit1();
    }

    public void goBack1() {
        backbut1 = findViewById(R.id.back1);
        backbut1.setOnClickListener(new View.OnClickListener() {

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

                RadioGroup radioGroup1 = findViewById(R.id.rgQuestion1);
                RadioGroup radioGroup2 = findViewById(R.id.rgQuestion2);
                RadioGroup radioGroup3 = findViewById(R.id.rgQuestion3);
                RadioGroup radioGroup4 = findViewById(R.id.rgQuestion4);

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
                    // No item selected

                    Context context = getApplicationContext();
                    CharSequence text = "Answer question 1!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if (checkedRadioButton2Id == -1) {
                        // No item selected

                        Context context = getApplicationContext();
                        CharSequence text = "Answer question 2!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        if (checkedRadioButton3Id == -1) {
                            // No item selected

                            Context context = getApplicationContext();
                            CharSequence text = "Answer question 3!";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {

                            if (checkedRadioButton4Id == -1) {
                                // No item selected

                                Context context = getApplicationContext();
                                CharSequence text = "Answer question 4!";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                if (score == 0) {
                                    Scor = "Your score is:\n" + score + "%";
                                } else {
                                    if (score == 25) {
                                        Scor = "Your score is:\n" + score + "%";
                                    } else {
                                        if (score == 50) {
                                            Scor = "Your score is:\n" + score + "%";
                                        } else {
                                            if (score == 75) {
                                                Scor = "Your score is:\n" + score + "%";
                                            } else {
                                                if (score == 100) {
                                                    Scor = "Your score is:\n" + score + "%";
                                                }
                                            }
                                        }
                                    }
                                }
                                Intent ResultActivity = new Intent(VocabularyActivity.this, ResultActivity.class);
                                ResultActivity.putExtra("scor", Scor);

                                startActivity(ResultActivity);
                            }
                        }
                    }
                }
            }
        });
    }
}
