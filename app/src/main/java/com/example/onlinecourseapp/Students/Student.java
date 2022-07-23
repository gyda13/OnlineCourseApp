package com.example.onlinecourseapp.Students;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.onlinecourseapp.DatabaseHelper;
import com.example.onlinecourseapp.MainActivity;
import com.example.onlinecourseapp.Quizizz.Quiz;
import com.example.onlinecourseapp.Quizizz.cs385quiz1;
import com.example.onlinecourseapp.R;
import com.example.onlinecourseapp.Notifications.ViewNotification;

public class Student extends AppCompatActivity {

    Button quiz,courses,notification;
    AlertDialog dialog;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);




        notification=  findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student.this, ViewNotification.class);
                startActivity(intent);
            }
        });

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


        Button logout =  findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                androidx.appcompat.app.AlertDialog alertDialog=new androidx.appcompat.app.AlertDialog.Builder(Student.this).create();
                alertDialog.setTitle("Logout");

                alertDialog.setMessage("Are you sure you want to logout?");
                alertDialog.setButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE,"Yes", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){


                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        Student.this.startActivity(intent);
                    }
                });
                alertDialog.setButton(androidx.appcompat.app.AlertDialog.BUTTON_NEGATIVE,"No", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){

                    }
                });
                alertDialog.show();


            }
        });

    }




}