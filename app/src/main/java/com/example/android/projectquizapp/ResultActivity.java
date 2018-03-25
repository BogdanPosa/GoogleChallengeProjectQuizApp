package com.example.android.projectquizapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {


    public Button sendFeedback;
    public Button homeButton;
    public Button share;
    boolean addSubjects;
    boolean addQuestions;
    boolean addFunctions;
    private CheckBox suggestion1;
    private CheckBox suggestion2;
    private CheckBox suggestion3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        goHome();
        sendFeedback();
        share();

        TextView text = findViewById(R.id.Score);
        text.setText(getIntent().getExtras().getString("score"));
        suggestion1 = findViewById(R.id.suggestion1);
        suggestion2 = findViewById(R.id.suggestion2);
        suggestion3 = findViewById(R.id.suggestion3);
    }

    /*
     * This method starts the Main activity
     */
    public void goHome() {
        homeButton = findViewById(R.id.homeButton2);
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent MainActivity = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }

    /*
     * This method display the Feedback responses
     */
    public void sendFeedback() {
        sendFeedback = findViewById(R.id.sendFeedback);
        sendFeedback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addSubjects = suggestion1.isChecked();
                addQuestions = suggestion2.isChecked();
                addFunctions = suggestion3.isChecked();
                RadioGroup radioGroupYN = findViewById(R.id.rgFeedbackYN);
                int ratedApp = radioGroupYN.getCheckedRadioButtonId();
                if (ratedApp == -1) {
                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.resultInfo1);
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if (ratedApp == R.id.FeedbackSelectionA) {
                        //Intents the feedback mail
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail2Subject));
                        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.suggestionMessage1) + addSubjects + getString(R.string.suggestionMessage2) + addQuestions + getString(R.string.suggestionMessage3) + addFunctions);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    } else {
                        if (ratedApp == R.id.FeedbackSelectionB) {
                            Context context = getApplicationContext();
                            CharSequence text = getString(R.string.resultInfo2);
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    }
                }
            }
        });
    }

    /*
     * This method intents the Share mail
     */
    public void share() {
        share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail1Subject));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.mail1Text));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}