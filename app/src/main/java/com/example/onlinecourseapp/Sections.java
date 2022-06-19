package com.example.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Dictionary;

public class Sections extends AppCompatActivity {

    ImageButton imageButton;
    Button s6c1,s6c2,s6c3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);




        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sections.this, Teachers.class);
                startActivity(intent);
            }
        });

        s6c1= findViewById(R.id.s6c1);
        s6c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Section6c1.class);
                startActivity(intent);
            }
        });


        s6c2= findViewById(R.id.s6c2);
        s6c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Section6c2.class);
                startActivity(intent);
            }
        });

        s6c3= findViewById(R.id.s6c3);
        s6c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Section6c3.class);
                startActivity(intent);
            }
        });






    }



}