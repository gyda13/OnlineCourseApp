package com.example.onlinecourseapp.Quizizz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.onlinecourseapp.R;

public class cs385quiz1 extends AppCompatActivity {


    int CorrectAnswerCount=0;
    int WrongAnswerCount=0;

    public void RadioButtonClickedQ1(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.q1_1:
                if (checked)
                    WrongAnswerCount++;
                break;
            case R.id.q1_2:
                if (checked)
                    CorrectAnswerCount++;
                break;
            case R.id.q1_3:
                if (checked)
                    WrongAnswerCount++;
                break;
        }
    }
    public void RadioButtonClickedQ2(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.q2_1:
                if (checked)
                    WrongAnswerCount++;
                break;
            case R.id.q2_2:
                if (checked)
                    CorrectAnswerCount++;
                break;
        }
    }

    public void RadioButtonClickedQ3(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.q3_true:
                if (checked)
                    CorrectAnswerCount++;

                break;
            case R.id.q3_false:
                if (checked)
                    WrongAnswerCount++;
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs385quiz1);


       Button submit =  findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog=new AlertDialog.Builder(cs385quiz1.this).create();
                alertDialog.setTitle("SCORE");

                alertDialog.setMessage("Yor Score Is: "+CorrectAnswerCount+"/3");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"Done", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){


                        Intent intent = new Intent(getApplicationContext(), Quiz.class);
                       cs385quiz1.this.startActivity(intent);
                    }
                });
                alertDialog.show();


            }
        });


    }
}