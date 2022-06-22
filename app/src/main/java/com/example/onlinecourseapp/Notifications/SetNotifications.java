package com.example.onlinecourseapp.Notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.onlinecourseapp.DatabaseHelper;
import com.example.onlinecourseapp.R;
import com.example.onlinecourseapp.Teachers.Teachers;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SetNotifications extends AppCompatActivity {


    EditText title,msg,course;
    FloatingActionButton addBtn;
    ImageButton imageButton;
    DatabaseHelper DB;
    RadioGroup radioGroup;
    String section="";
    public void RadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.s6c1:
                if (checked)
                    section = "6c1";
                break;
            case R.id.s6c2:
                if (checked)
                    section = "6c2";
                break;
            case R.id.s6c3:
                if (checked)
                    section = "6c3";
                break;
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_notifications);


        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetNotifications.this, Teachers.class);
                startActivity(intent);
            }
        });


        title =  findViewById(R.id.title);
        msg =  findViewById(R.id.msg);
        course =  findViewById(R.id.course);

        DB = new DatabaseHelper(this);
        addBtn = (FloatingActionButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = title.getText().toString();
                String Msg = msg.getText().toString();
                String Course = course.getText().toString();

                Boolean insert = DB.InsertNotifications(Title,Course,Msg,section);
                if(insert){
                    Toast.makeText(SetNotifications.this, "Message Inserted", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    }


