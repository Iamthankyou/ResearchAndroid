package com.example.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "schoolManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String NAMECLASS = "class";
    private static final String BIRTHDAY = "birthday";
    private static final String AVATAR = "avatar";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, ID, NAME, NAMECLASS, AVATAR,BIRTHDAY);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, String.valueOf(student.getId()));
        values.put(NAME, student.getName());
        values.put(NAMECLASS, student.getNameClass());
        values.put(AVATAR, student.getUrlAvatar());
        values.put(BIRTHDAY, student.getBirthday());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Student getStudent(String studentId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, ID + " = ?", new String[] { studentId},null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
        return student;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student>  studentList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Student student = new Student(cursor.getString(3), cursor.getString(1), cursor.getString(2), cursor.getString(0),cursor.getString(4));
            studentList.add(student);
            cursor.moveToNext();
        }

        return studentList;
    }

    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME, student.getName());
        values.put(ID, String.valueOf(student.getId()));
        values.put(NAMECLASS, student.getNameClass());
        values.put(BIRTHDAY, student.getBirthday());
        values.put(AVATAR, student.getUrlAvatar());

        db.update(TABLE_NAME, values, ID + " = ?", new String[] { student.getId()});
        db.close();
    }

    public void deleteStudent(String studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?", new String[] { studentId });
        db.close();
    }
}
