package com.example.template;


import java.util.ArrayList;

public class Application extends android.app.Application {
    public static ArrayList<Table_LeQuangDuy> list;
    private static LeQuangDuy_sqlite db;
//    private LeQuangDuy_sqlite db;

    @Override
    public void onCreate() {
        super.onCreate();

        list = new ArrayList<>();

        db = new LeQuangDuy_sqlite(this);

//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
        db.add(new Table_LeQuangDuy("STRING", 80.88, 1));

        list = db.getAll();
    }

    public static void delele(int pos){
        db.delete(pos);
        list = db.getAll();
    }




}

