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

public class Department extends AppCompatActivity {
    EditText hodname,hodreg,dname;
    Button btn;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        hodname = findViewById(R.id.et2);
        hodreg = findViewById(R.id.et3);
        dname = findViewById(R.id.et4);
        btn = findViewById(R.id.button);

        //databasehelper object
        mydb = new DatabaseHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean isinserted =  mydb.InsertDatadepart(hodname.getText().toString(),
                        hodreg.getText().toString(),dname.getText().toString());
              if(isinserted == false)
                  Toast.makeText(Department.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
              else
                  Toast.makeText(Department.this, "Data Inserted", Toast.LENGTH_SHORT).show();
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

            startActivity(new Intent(Department.this,SearchUpdateDeleteDep.class));
        }
        return true;
    }
}
