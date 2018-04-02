package com.example.sufiyananis.sqliteassignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchUpdateDeleteDep extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText name ,reg,dept;
    TextView sname,sdep;
    Button search,update,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_update_delete_dep);

        name = findViewById(R.id.ett2);
        reg = findViewById(R.id.ett3);
        dept = findViewById(R.id.ett4);

        //textview
        sname =findViewById(R.id.s1);
        sdep = findViewById(R.id.s2);
        //button
        search=findViewById(R.id.searchb);
        update = findViewById(R.id.updateb);
        delete=findViewById(R.id.deleteb);

        //database
        mydb = new DatabaseHelper(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data =mydb.Searchdep(reg.getText().toString());

                while(data.moveToNext()){
                    sname.setText(data.getString(1));
                    sdep.setText(data.getString(3));

                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb.Updatedep(name.getText().toString(),reg.getText().toString(),dept.getText().toString());
                startActivity(new Intent(SearchUpdateDeleteDep.this,MainActivity.class));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb.Deletedep(reg.getText().toString());
                startActivity(new Intent(SearchUpdateDeleteDep.this,MainActivity.class));
            }
        });
    }

}
