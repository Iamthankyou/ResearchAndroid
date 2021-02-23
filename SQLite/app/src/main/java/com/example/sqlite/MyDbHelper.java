package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final String DBName = "mydb.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static String YEAR = "year";

    public MyDbHelper(@Nullable Context context) {
        super(context, DBName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT)", TABLE_NAME,ID,NAME,YEAR);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, student.getId());
        values.put(NAME, student.getName());
        values.put(YEAR, student.getYear());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Student getStudent(int studentId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, ID + " = ?", new String[] { String.valueOf(studentId) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        Student student = new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2));

        return student;
    }

    public void updateStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, student.getName());
        values.put(YEAR, student.getYear());

        db.update(TABLE_NAME, values, ID + " = " + student.getId(), null);
        db.close();
    }

    public long deleteStudent(String id){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_NAME, ID + " = " + id, null);
            db.close();
            return 1;
        }
        catch(Exception e){
            return 0;
        }
    }
}
