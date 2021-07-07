package com.example.practice1_1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "songManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "song";

    private static final String ID = "id";
    private static final String SONG = "name_song";
    private static final String SINGER = "singer";
    private static final String  TIME = "time";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_song_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s DOUBLE)", TABLE_NAME, ID, SONG, SINGER, TIME);
        db.execSQL(create_song_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);
    }

    public void addSong(Song song) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, String.valueOf(song.getId()));
        values.put(SONG, song.getName());
        values.put(SINGER, song.getSinger());
        values.put(TIME, song.getTime());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Song getSong(String studentId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, ID + " = ?", new String[] { studentId},null, null, null);

        if(cursor != null)
            cursor.moveToFirst();
        else{
            return null;
        }

        Song song = new Song(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getDouble(3));
        return song;
    }

    public ArrayList<Song> getAllSong() {
        ArrayList<Song>  studentList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Song student = new Song(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getDouble(3));
            studentList.add(student);
            cursor.moveToNext();
        }

        return studentList;
    }

    public void updateStudent(Song student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SONG, student.getName());
        values.put(ID, String.valueOf(student.getId()));
        values.put(SINGER, student.getSinger());
        values.put(TIME, student.getTime());

        db.update(TABLE_NAME, values, ID + " = ?", new String[] { student.getId().toString()});
        db.close();
    }

    public void deleteStudent(String studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?", new String[] { studentId });
        db.close();
    }
}