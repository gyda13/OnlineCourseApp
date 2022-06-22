package com.example.onlinecourseapp.Sections;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.onlinecourseapp.DatabaseHelper;
import com.example.onlinecourseapp.R;

public class Section6c3 extends AppCompatActivity {


    ImageButton imageButton;
    TextView info6c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section6c3);

        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Section6c3.this, Sections.class);
                startActivity(intent);
            }
        });




        DatabaseHelper DB=new DatabaseHelper(this);

        info6c3 =  findViewById(R.id.info6c3);
        Cursor cursor=DB.ViewData6c3();
        StringBuilder stringBuilder=new StringBuilder();

        while (cursor.moveToNext()){

            stringBuilder.append("\nID:"+cursor.getString(0)+
                    "\nSection:"+cursor.getString(2)+
                    "\nStudent Name:"+cursor.getString(3)+
                    " "+cursor.getString(4)
            );

            info6c3.setText(stringBuilder);

            info6c3.setText(stringBuilder+"\n"+"--------------------------");

        }


    }
}