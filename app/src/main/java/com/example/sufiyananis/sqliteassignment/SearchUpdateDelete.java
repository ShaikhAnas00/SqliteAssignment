package com.example.sufiyananis.sqliteassignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SearchUpdateDelete extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText name ,reg,dept,email;
    TextView sname,sdep,semail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_update_delete);

        name = findViewById(R.id.et2);
        reg = findViewById(R.id.et3);
        dept = findViewById(R.id.et4);
        email= findViewById(R.id.et5);
        //textview
        sname =findViewById(R.id.s1);
        sdep = findViewById(R.id.s2);
        semail=findViewById(R.id.s3);
        //database
        mydb = new DatabaseHelper(this);

    }
    public void Update(View v){
        mydb.Update(name.getText().toString(),reg.getText().toString(),dept.getText().toString(),email.getText().toString());
        startActivity(new Intent(SearchUpdateDelete.this,MainActivity.class));

    }
    public void Delete(View v){
        mydb.Delete(reg.getText().toString());
        startActivity(new Intent(SearchUpdateDelete.this,MainActivity.class));
    }
    public void Search(View v){
        Cursor data =mydb.Search(reg.getText().toString());

        while(data.moveToNext()){
            sname.setText(data.getString(1));
            sdep.setText(data.getString(3));
            semail.setText(data.getString(4));
        }

    }
}
