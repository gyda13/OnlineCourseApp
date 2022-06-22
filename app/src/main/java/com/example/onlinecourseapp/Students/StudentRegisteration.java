package com.example.onlinecourseapp.Students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.onlinecourseapp.DatabaseHelper;
import com.example.onlinecourseapp.MainActivity;
import com.example.onlinecourseapp.R;

public class StudentRegisteration extends AppCompatActivity {


    EditText password,repassword,id,firstname,lastname;
    Button signup;
    Switch login;
    DatabaseHelper DB;
    ImageButton imageButton;
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
        setContentView(R.layout.activity_student_registeration);


        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        id = findViewById(R.id.id);
        signup =  findViewById(R.id.signup);
        imageButton =  findViewById(R.id.imageButton);
        login =  findViewById(R.id.login);
        DB = new DatabaseHelper(this);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);





        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String FirstName = firstname.getText().toString();
                String LastName = lastname.getText().toString();
                String Id = id.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                int selectedId = radioGroup.getCheckedRadioButtonId();




                if ( FirstName.equals("")||LastName.equals("")||pass.equals("") || repass.equals("") || Id.equals("")||selectedId==-1) {

                        Toast.makeText(StudentRegisteration.this, "All fields Required", Toast.LENGTH_SHORT).show();

                } else {
                    if (pass.equals(repass) == true) {
                        Boolean checkuser = DB.checkIdStudent(Id);
                        if (checkuser == false) {
                            Boolean insert = DB.InsertStudentData(Id, pass,section,FirstName,LastName);
                            if (insert == true) {
                                Toast.makeText(StudentRegisteration.this, "Registerd Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Student.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(StudentRegisteration.this, "Registerd Failed", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(StudentRegisteration.this, "User Already Exists", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(StudentRegisteration.this, "password are not matching", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


        login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Intent intent = new Intent(getApplicationContext(), StudentLogin.class);
                    startActivity(intent);
                }
                else{

                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentRegisteration.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}