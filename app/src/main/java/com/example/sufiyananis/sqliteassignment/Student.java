package com.example.sufiyananis.sqliteassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Student extends AppCompatActivity {
    EditText name,reg,dept,email;
    Button btn;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        name = findViewById(R.id.et2);
        reg = findViewById(R.id.et3);
        dept = findViewById(R.id.et4);
        email = findViewById(R.id.et5);
        btn = findViewById(R.id.button);

        //Databasehelper object
        mydb = new DatabaseHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isinsert = mydb.InsertDatastudent(name.getText().toString(),
                        reg.getText().toString(),dept.getText().toString(),email.getText().toString());

               if(!isinsert)
                   Toast.makeText(Student.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(Student.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if(item.getItemId() == R.id.search || item.getItemId() == R.id.update || item.getItemId() == R.id.Delete){

            startActivity(new Intent(Student.this,SearchUpdateDelete.class));
        }
        return true;
    }
}
