package com.example.onlinecourseapp.Students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.onlinecourseapp.DatabaseHelper;
import com.example.onlinecourseapp.MainActivity;
import com.example.onlinecourseapp.R;

public class StudentLogin extends AppCompatActivity {


    EditText id,password;
    Button login;
    DatabaseHelper DB;
    Switch register;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        id=findViewById(R.id.id);
        password=findViewById(R.id.password);
        login= findViewById(R.id.login);
        register=findViewById(R.id.register);
        DB=new DatabaseHelper(this);



        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLogin.this, MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Id=id.getText().toString();
                String pass=password.getText().toString();

                if(Id.equals("")||pass.equals("")){
                    Toast.makeText(StudentLogin.this, "All fields Required",Toast.LENGTH_SHORT).show();

                } else{
                    Boolean checkuserpass=DB.checkIdpasswordStudent(Id,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(StudentLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Student.class);
                        intent.putExtra("StudentId",Id);
                        startActivity(intent);
                    }else{
                        Toast.makeText(StudentLogin.this, "Login Failed, Id or password is wrong!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        register.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Intent intent = new Intent(getApplicationContext(), StudentRegisteration.class);
                    startActivity(intent);
                }
                else{


                }            }
        });




    }


}