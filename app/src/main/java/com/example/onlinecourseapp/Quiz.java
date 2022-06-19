package com.example.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Quiz extends AppCompatActivity {


    Button quiz385;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz.this, Student.class);
                startActivity(intent);
            }
        });


        quiz385= findViewById(R.id.quiz385);
        quiz385.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz.this, cs385quiz1.class);
                startActivity(intent);
            }
        });



    }
}