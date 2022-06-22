package com.example.onlinecourseapp.Notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.onlinecourseapp.DatabaseHelper;
import com.example.onlinecourseapp.R;
import com.example.onlinecourseapp.Students.Student;

public class ViewNotification extends AppCompatActivity {


    ImageButton imageButton;
    TextView not;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notification);



        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewNotification.this, Student.class);
                startActivity(intent);
            }
        });


        DatabaseHelper DB=new DatabaseHelper(this);

/*
        not =  findViewById(R.id.not);
        Cursor cursor=DB.Msg6c1();
        StringBuilder stringBuilder=new StringBuilder();

        while (cursor.moveToNext()){

            stringBuilder.append("\n--"+cursor.getString(0)+"--"+
                    "\n "+cursor.getString(1)+
                    "\n "+cursor.getString(2)

            );

            not.setText(stringBuilder+"\n"+"--------------------------");

        }

 */

    }
}