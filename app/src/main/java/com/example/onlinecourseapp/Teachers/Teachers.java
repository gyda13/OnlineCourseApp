package com.example.onlinecourseapp.Teachers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onlinecourseapp.MainActivity;
import com.example.onlinecourseapp.R;
import com.example.onlinecourseapp.Sections.Sections;
import com.example.onlinecourseapp.Notifications.SetNotifications;
import com.example.onlinecourseapp.Students.Student;

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

        Button logout =  findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                androidx.appcompat.app.AlertDialog alertDialog=new androidx.appcompat.app.AlertDialog.Builder(Teachers.this).create();
                alertDialog.setTitle("Logout");

                alertDialog.setMessage("Are you sure you want to logout?");
                alertDialog.setButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE,"Yes", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){


                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        Teachers.this.startActivity(intent);
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