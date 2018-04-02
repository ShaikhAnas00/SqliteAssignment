package com.example.sufiyananis.sqliteassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sufiyan Anis on 4/1/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_Student = "Student_t";
    private static final String TABLE_Depart = "Department_t";

    /// columns for Student table
    private static final String ID = "id";
    private static final String Name = "name";
    private static final String Regno = "regno";
    private static final String Dept = "depart";
    private static final String Email = "email";

    // columns for Department Table
    private static final String DID = "id";
    private static final String HODName = "hodname";
    private static final String DRegno = "dregno";
    private static final String DName = "dname";

    String SQLite1 = "CREATE TABLE "+TABLE_Student+" (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,regno TEXT,depart TEXT,email TEXT)";
    String SQLite2 = "CREATE TABLE "+TABLE_Depart+" (id INTEGER PRIMARY KEY AUTOINCREMENT,hodname TEXT,dregno TEXT,dname TEXT)";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLite2);
        db.execSQL(SQLite1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_Student);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_Depart);
        onCreate(db);
    }
    public boolean InsertDatastudent(String name ,String regno,String depart,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(Regno,regno);
        contentValues.put(Dept,depart);
        contentValues.put(Email,email);
       long res= db.insert(TABLE_Student,null,contentValues);
        if(res == -1){
            return false;
        }else
            return true;

    }
    public boolean InsertDatadepart(String hodname ,String hodregno,String dname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HODName,hodname);
        contentValues.put(DRegno,hodregno);
        contentValues.put(DName,dname);

       long result= db.insert(TABLE_Depart,null,contentValues);
       if(result == -1){
           return false;
       }else
           return true;
    }
    public Cursor getList(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select DISTINCT * from "+TABLE_Student;
       Cursor data = db.rawQuery(query,null);
       return data;
    }

    public Cursor getListDepart(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select DISTINCT * from "+TABLE_Depart;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    public void Update(String name ,String regno,String depart,String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name, name);
        contentValues.put(Dept, depart);
        contentValues.put(Email, email);
        db.update(TABLE_Student,contentValues,"regno = '" +regno+"'",null) ;
    }
    public void Updatedep(String name ,String regno,String depart) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name, name);
        contentValues.put(Dept, depart);
        db.update(TABLE_Depart,contentValues,"dregno = '" +regno+"'",null) ;
    }
    public void Delete(String regno){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Student,"regno = '" +regno+"'",null);
    }
    public void Deletedep(String regno){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Depart,"dregno = '" +regno+"'",null);
    }
    public Cursor Search(String regno){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+TABLE_Student+" where regno = '" +regno+"'";
        Cursor cursor = db.rawQuery(query,null);
                return cursor;
    }
    public Cursor Searchdep(String regno){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+TABLE_Depart+" where dregno = '" +regno+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public Cursor retrieve(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="Select name from "+TABLE_Student+" Where depart = 'bsse'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
