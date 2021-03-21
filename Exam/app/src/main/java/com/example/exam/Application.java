package com.example.exam;

import java.util.ArrayList;

public class Application extends android.app.Application {
    public static ArrayList<Student> listStudent;

    @Override
    public void onCreate() {
        super.onCreate();

        listStudent = new ArrayList<>();

        listStudent.add(new Student("null","Lê Quang Duy","CNTT1","181203460","02/03/2000"));
        listStudent.add(new Student("null","Phạm Thị Thu Hiền","null","181203461","22/12/2000"));
    }
}
