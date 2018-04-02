package com.example.sufiyananis.sqliteassignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Students extends AppCompatActivity implements View.OnClickListener {

Button viewall;
    DatabaseHelper mydb;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        viewall = findViewById(R.id.viewall);
        mydb = new DatabaseHelper(this);
      viewall.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add){
            startActivity(new Intent(Students.this,Student.class));
        }else if(item.getItemId() == R.id.search || item.getItemId() == R.id.update || item.getItemId() == R.id.Delete){

            startActivity(new Intent(Students.this,SearchUpdateDelete.class));
        }
        else if (item.getItemId() == R.id.other){
            startActivity(new Intent(Students.this,Other.class));
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == viewall){
        ListView listView = findViewById(R.id.list);
        ArrayList<String> list =new ArrayList<>();
        Cursor cursor = mydb.getList();
        if(cursor.getCount() == 0){
            Toast.makeText(Students.this, "The List is empty", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                list.add(cursor.getString(0)+"\n"+
                        cursor.getString(1)+"\n"+
                        cursor.getString(2)+"\n"+
                        cursor.getString(3)+"\n"+
                        cursor.getString(4)+"\n");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
                listView.setAdapter(arrayAdapter);
            }
        }
    }}
}
