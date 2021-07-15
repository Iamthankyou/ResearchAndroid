package com.example.lequangduy_181203460;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Sqlite_181203460 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "data";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "taxi_LeQuangDuy";

    private static final String COLUMN0 = "id";
    private static final String COLUMN1 = "soXe";
    private static final String COLUMN2 = "quangDuong";
    private static final String COLUMN3 = "donGia";
    private static final String COLUMN4 = "khuyenMai";

    public Sqlite_181203460(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s DOUBLE, %s INTEGER, %s INTEGER)", TABLE_NAME, COLUMN0, COLUMN1, COLUMN2, COLUMN3, COLUMN4);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);

    }

    public void add(Taxi_LeQuangDuy record) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(COLUMN0,record.getColumnInt());
        values.put(COLUMN1, record.getSoXe());
        values.put(COLUMN2, record.getQuangDuong());
        values.put(COLUMN3, record.getDonGia());
        values.put(COLUMN4, record.getKhuyenMai());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Taxi_LeQuangDuy get(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, COLUMN0 + " = ?", new String[] {id},null, null, null);

        if(cursor != null)
            cursor.moveToFirst();
        else{
            return null;
        }

        Taxi_LeQuangDuy one = new Taxi_LeQuangDuy(cursor.getInt(0), cursor.getString(1),  cursor.getDouble(2),cursor.getInt(3),cursor.getInt(3));
        return one;
    }

    public ArrayList<Taxi_LeQuangDuy> getAll() {
        ArrayList<Taxi_LeQuangDuy>  list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME   ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Taxi_LeQuangDuy one = new Taxi_LeQuangDuy(cursor.getInt(0), cursor.getString(1),  cursor.getDouble(2),cursor.getInt(3),cursor.getInt(3));

            list.add(one);
            cursor.moveToNext();
        }

        return list;
    }

    public void update(Taxi_LeQuangDuy t) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN0, t.getId());
        values.put(COLUMN1, t.getSoXe());
        values.put(COLUMN2, t.getQuangDuong());
        values.put(COLUMN3, t.getDonGia());
        values.put(COLUMN4, t.getKhuyenMai());


        db.update(TABLE_NAME, values, COLUMN0 + " = ?", new String[] { String.valueOf(t.getId())});
        db.close();
    }

    public void delete(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN0 + " = ?", new String[] { String.valueOf(studentId) });
        db.close();
    }
}
