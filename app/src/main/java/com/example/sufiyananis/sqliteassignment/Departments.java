package com.example.sufiyananis.sqliteassignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Departments extends AppCompatActivity implements View.OnClickListener {
Button viewall;
        DatabaseHelper mydb;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);


        viewall = findViewById(R.id.viewall);
        mydb = new DatabaseHelper(this);
        viewall.setOnClickListener(this);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Cursor data =mydb.retrieve();
//                StringBuffer buffer = new StringBuffer();
//                while(data.moveToNext()){
//                    buffer.append(data.getString(1));
//                }
//                showMessage("Data",buffer.toString());
//            }
//        });
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add){
            startActivity(new Intent(Departments.this,Department.class));
        }else if(item.getItemId() == R.id.search || item.getItemId() == R.id.update || item.getItemId() == R.id.Delete){

            startActivity(new Intent(Departments.this,SearchUpdateDeleteDep.class));
        }else if (item.getItemId() == R.id.other){
            startActivity(new Intent(Departments.this,Other.class));
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        if(view == viewall){
            listView = findViewById(R.id.list);
            ArrayList<String> list =new ArrayList<>();
            Cursor cursor = mydb.getListDepart();
            if(cursor.getCount() == 0){
                Toast.makeText(Departments.this, "The List is empty", Toast.LENGTH_SHORT).show();
            }else{
                while(cursor.moveToNext()){
                    list.add(cursor.getString(0)+"\n"+
                            cursor.getString(1)+"\n"+
                            cursor.getString(2)+"\n"+
                            cursor.getString(3)+"\n");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
                    listView.setAdapter(arrayAdapter);
                }
            }
        }}

}
