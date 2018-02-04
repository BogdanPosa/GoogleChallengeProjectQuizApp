package com.example.android.projectquizapp;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.projectquizapp.R;
import com.example.android.projectquizapp.VocabularyActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        startHelping();
    }

    public Button but1;
    public void startHelping() {
        but1 = (Button) findViewById(R.id.start);
        but1.setOnClickListener(new View.OnClickListener() {
        RadioButton selectionA = (RadioButton) findViewById(R.id.buttonSelectionA);
        RadioButton selectionB = (RadioButton) findViewById(R.id.buttonSelectionB);

            @Override
            public void onClick(View view) {
                if (selectionB.isChecked()) {
                    Intent Math = new Intent(MainActivity.this, MathActivity.class);
                    startActivity(Math);
                } else if(selectionA.isChecked()) {
                    Intent Vocabulary = new Intent(MainActivity.this, VocabularyActivity.class);
                    startActivity(Vocabulary);
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Pick one category!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}