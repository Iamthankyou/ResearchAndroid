package com.example.template;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LeQuangDuy_sqlite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "schoolManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    private static final String COLUMN0 = "id";
    private static final String COLUMN1 = "stringColumn";
    private static final String COLUMN2 = "doubleColumn";
    private static final String COLUMN3 = "booleanColumn";
    private static final String COLUMN4 = "avatar";

    public LeQuangDuy_sqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, ID, NAME, NAMECLASS, AVATAR,BIRTHDAY);
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s DOUBLE, %s INTEGER)", TABLE_NAME, COLUMN0, COLUMN1, COLUMN2, COLUMN3);
        db.execSQL(create_students_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);

    }

    public void add(Table_LeQuangDuy record) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(COLUMN0,record.getColumnInt());
        values.put(COLUMN1, record.getColumnString());
        values.put(COLUMN2, record.getColumnDouble());
        values.put(COLUMN3, record.isColumnBoolean());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Table_LeQuangDuy get(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, COLUMN0 + " = ?", new String[] {id},null, null, null);

        if(cursor != null)
            cursor.moveToFirst();
        else{
            return null;
        }

        Table_LeQuangDuy one = new Table_LeQuangDuy(cursor.getInt(0), cursor.getString(1),  cursor.getDouble(2),cursor.getInt(3));
        return one;
    }

    public ArrayList<Table_LeQuangDuy> getAll() {
        ArrayList<Table_LeQuangDuy>  list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Table_LeQuangDuy one = new Table_LeQuangDuy(cursor.getInt(0), cursor.getString(1),  cursor.getDouble(2),cursor.getInt(3));

            list.add(one);
            cursor.moveToNext();
        }

        return list;
    }

    public void update(Table_LeQuangDuy t) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN0, t.getColumnInt());
        values.put(COLUMN1, t.getColumnString());
        values.put(COLUMN2, t.getColumnDouble());
        values.put(COLUMN3, t.isColumnBoolean());

        db.update(TABLE_NAME, values, COLUMN0 + " = ?", new String[] { String.valueOf(t.getColumnInt())});
        db.close();
    }

    public void delete(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN0 + " = ?", new String[] { String.valueOf(studentId) });
        db.close();
    }
}
