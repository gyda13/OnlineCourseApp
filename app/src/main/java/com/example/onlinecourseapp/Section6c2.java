package com.example.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Section6c2 extends AppCompatActivity {


    ImageButton imageButton;
    TextView info6c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section6c2);

        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Section6c2.this, Sections.class);
                startActivity(intent);
            }
        });




        DatabaseHelper DB=new DatabaseHelper(this);

        info6c2 =  findViewById(R.id.info6c2);
        Cursor cursor=DB.ViewData6c2();
        StringBuilder stringBuilder=new StringBuilder();

        while (cursor.moveToNext()){

            stringBuilder.append("\nID:"+cursor.getString(0)+
                    "\nSection:"+cursor.getString(2)+
                    "\nStudent Name:"+cursor.getString(3)+
                    " "+cursor.getString(4)
            );

            info6c2.setText(stringBuilder);

            info6c2.setText(stringBuilder+"\n"+"--------------------------");

        }


    }
}