package com.example.sufiyananis.sqliteassignment;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class Other extends AppCompatActivity {
DatabaseHelper mydb;
TextView showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        mydb = new DatabaseHelper(this);
        showMessage = findViewById(R.id.t2);
        showMessage.setText("");
        String s = showMessage.getText().toString();

    }

    public void Show(View v){
        String s = showMessage.getText().toString();
                Cursor data =mydb.retrieve();
                StringBuffer buffer = new StringBuffer();
                while(data.moveToNext()){
                    showMessage.setText(s+"    "+data.getString(1));
                }


    }
}
