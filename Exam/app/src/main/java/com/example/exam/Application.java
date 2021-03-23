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

//        db.addStudent(new Student("Lê Quang Duy","1017"));
//        db.addStudent(new Student("Lê Quang Duy 1","1018"));
//        db.addStudent(new Student("Lê Quang Duy 2","1019"));
//        db.addStudent(new Student("Lê Quang Duy 3","1020"));
//
//        db.addStudent(new Student("Phạm Thị Thu Hiền","391017"));
//        db.addStudent(new Student("Phạm Thị Thu Hiền 1","391018"));
//        db.addStudent(new Student("Phạm Thị Thu Hiền 2","391010"));
//        db.addStudent(new Student("Phạm Thị Thu Hiền 3","3923010"));


        listStudent = db.getAllStudents();

//        listStudent.add(new Student("null","Lê Quang Duy","CNTT1","181203460","02/03/2000"));
//        listStudent.add(new Student("null","Phạm Thị Thu Hiền","null","181203461","22/12/2000"));
    }



}
