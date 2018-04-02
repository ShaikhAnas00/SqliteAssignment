package com.example.sufiyananis.sqliteassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void Student(View v){
        startActivity(new Intent(MainActivity.this,Student.class));
    }
    public void Department(View v){
        startActivity(new Intent(MainActivity.this,Department.class));
    }


    public void viewStudent(View v){
        startActivity(new Intent(MainActivity.this,Students.class));
    }
    public void viewDepartment(View v){
        startActivity(new Intent(MainActivity.this,Departments.class));
    }


}
