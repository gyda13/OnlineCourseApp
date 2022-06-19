package com.example.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Student extends AppCompatActivity {

    Button quiz,courses;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        quiz =  findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student.this, Quiz.class);
                startActivity(intent);
            }
        });


        courses =  findViewById(R.id.courses);
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1=getLayoutInflater().inflate(R.layout.courses,null);

                ImageButton imageButton;
                imageButton=view1.findViewById(R.id.imageButton);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      dialog.dismiss();
                    }
                });

                builder=new AlertDialog.Builder(Student.this);
                builder.setView(view1);
                dialog=builder.create();
                dialog.show();

            }
        });



    }




}