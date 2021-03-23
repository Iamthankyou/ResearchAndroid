package com.example.exam;

import java.util.ArrayList;

public class Application extends android.app.Application {
    public static ArrayList<Student> listStudent;
    private MyDbHelper db;

    @Override
    public void onCreate() {
        super.onCreate();

        listStudent = new ArrayList<>();

        db = new MyDbHelper(this);

//        db.addStudent(new Student("null","Lê Quang Duy","CNTT1","1","02032000"));

        listStudent = db.getAllStudents();

//        listStudent.add(new Student("null","Lê Quang Duy","CNTT1","181203460","02/03/2000"));
//        listStudent.add(new Student("null","Phạm Thị Thu Hiền","null","181203461","22/12/2000"));
    }



}
