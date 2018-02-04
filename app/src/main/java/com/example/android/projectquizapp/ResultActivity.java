package com.example.android.projectquizapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        goBack2();
        sendfeedback();
        share();

            TextView text= (TextView)findViewById(R.id.Score);
            text.setText(getIntent().getExtras().getString("scor"));

    }

    public Button sendfeed;
    public Button backbut2;
    public Button share;

    /**
     * This method starts the Main activity
     */

    public void goBack2() {
        backbut2 = (Button) findViewById(R.id.back2);
        backbut2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent MainActivity = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }

    /**
     * This method display the Feedback responses
     */
    public void sendfeedback() {
        sendfeed = (Button) findViewById(R.id.sendfeedback);
        sendfeed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                RadioGroup radioGroupYN = (RadioGroup) findViewById(R.id.rgFeedbackYN);
                int ratedapp = radioGroupYN.getCheckedRadioButtonId();
                if (ratedapp == -1) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please select your answer!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if (ratedapp == R.id.FeedbackSelectionA) {
                        Context context = getApplicationContext();
                        CharSequence text = "Thank you for your feedback!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        if (ratedapp == R.id.FeedbackSelectionB) {
                            Context context = getApplicationContext();
                            CharSequence text = "How about you reconsider your answer!";
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    }
                }
            }
        });
    }

    /**
     * This method intents the mail
     */
    public void share() {
        share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Join me in the fight against world hunger!");
                intent.putExtra(Intent.EXTRA_TEXT, "Over a billion people suffer from hunger, there is an organization that serves food for the people in need.\n \nYou can contribute by playing their game: 'Make world better'\n\n Let's make the world a slightly better place!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}