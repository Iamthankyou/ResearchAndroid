package com.example.lequangduy_181203460;



import java.util.ArrayList;

public class Application extends android.app.Application {
    public static ArrayList<Taxi_LeQuangDuy> list;
    private static Sqlite_181203460 db;
//    private LeQuangDuy_sqlite db;

    @Override
    public void onCreate() {
        super.onCreate();

        list = new ArrayList<>();

        db = new Sqlite_181203460(this);

//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
//        db.add(new Table_LeQuangDuy("String", 80.88, 0));
//        db.add(new Table_LeQuangDuy("STRING", 8099.88, 1));

        db.add(new Taxi_LeQuangDuy("343DDD",24.2,10,2));
        db.add(new Taxi_LeQuangDuy("343DDD",24.2,12,3));
        db.add(new Taxi_LeQuangDuy("343DDD",24.2,14,4));
        db.add(new Taxi_LeQuangDuy("343DDD",32.4,10,5));
        db.add(new Taxi_LeQuangDuy("37",30.1,20,6));
        db.add(new Taxi_LeQuangDuy("37KDKJF",30.1,20,6));
        db.add(new Taxi_LeQuangDuy("3FJDFJ",30.1,20,6));

        list = db.getAll();
    }

    public static void delele(int pos){
        db.delete(pos);
        list = db.getAll();
    }

    public static void add(Taxi_LeQuangDuy aNew){
        db.add(aNew);
    }
}

