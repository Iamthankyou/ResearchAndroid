package com.example.practice1_1;

import java.util.ArrayList;

public class Application extends android.app.Application {
    public static ArrayList<Song> listStudent;
    private MyDbHelper db;

    @Override
    public void onCreate() {
        super.onCreate();

        listStudent = new ArrayList<>();

        db = new MyDbHelper(this);

        db.addSong(new Song(1,"My heart will go on", "Empty", 350));
        db.addSong(new Song(2,"Perfect", "Edd sherran", 360));

        listStudent = db.getAllSong();

//        listStudent.add(new Student("null","Lê Quang Duy","CNTT1","181203460","02/03/2000"));
//        listStudent.add(new Student("null","Phạm Thị Thu Hiền","null","181203461","22/12/2000"));
    }



}