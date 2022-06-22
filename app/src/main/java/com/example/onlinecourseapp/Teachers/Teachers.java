package com.example.onlinecourseapp.Teachers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onlinecourseapp.R;
import com.example.onlinecourseapp.Sections.Sections;
import com.example.onlinecourseapp.Notifications.SetNotifications;

public class Teachers extends AppCompatActivity {


    Button sections,setNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);




        sections= findViewById(R.id.sections);
        sections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teachers.this, Sections.class);
                startActivity(intent);
            }
        });

        setNotifications= findViewById(R.id.setNotifications);
        setNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teachers.this, SetNotifications.class);
                startActivity(intent);
            }
        });
    }
}