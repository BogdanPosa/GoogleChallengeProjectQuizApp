package com.example.android.projectquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    public Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        startHelping();
    }


    /*
  * This method starts the math or the vocabulary activity based on user selection
  */
    public void startHelping() {
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            RadioButton selectionA = (RadioButton) findViewById(R.id.buttonSelectionA);
            RadioButton selectionB = (RadioButton) findViewById(R.id.buttonSelectionB);

            @Override
            public void onClick(View view) {
                if (selectionB.isChecked()) {
                    Intent Math = new Intent(MainActivity.this, MathActivity.class);
                    startActivity(Math);
                } else if (selectionA.isChecked()) {
                    Intent Vocabulary = new Intent(MainActivity.this, VocabularyActivity.class);
                    startActivity(Vocabulary);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.mainInfo);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}