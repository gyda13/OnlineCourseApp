package com.example.onlinecourseapp.Teachers;

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

public class TeachersRegisteration extends AppCompatActivity {

    EditText password,repassword,firstname,lastname,id;
    Button signup;
   Switch login;
    DatabaseHelper DB;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);





        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        id = findViewById(R.id.id);
        signup =  findViewById(R.id.signup);
       login =  findViewById(R.id.login);
        DB = new DatabaseHelper(this);
        imageButton =  findViewById(R.id.imageButton);





        login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Intent intent = new Intent(getApplicationContext(), TeachersLogin.class);
                    startActivity(intent);
                }
                else{

                }
            }
        });



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeachersRegisteration.this, MainActivity.class);
                startActivity(intent);
            }
        });






        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Id = id.getText().toString();
                String FirstName = firstname.getText().toString();
                String LastName = lastname.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();


                if (FirstName.equals("") || pass.equals("") || repass.equals("") || LastName.equals("") || Id.equals("")) {
                    Toast.makeText(TeachersRegisteration.this, "All fields Required", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass) == true) {
                        Boolean checkuser = DB.checkTeacherId(Id);
                        if (checkuser == false) {
                            Boolean insert = DB.InsertTeachersData(Id, pass,FirstName,LastName);
                            if (insert == true) {
                                Toast.makeText(TeachersRegisteration.this, "Registerd Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Teachers.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(TeachersRegisteration.this, "Registerd Failed", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(TeachersRegisteration.this, "User Already Exists", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(TeachersRegisteration.this, "password are not matching", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

    }
