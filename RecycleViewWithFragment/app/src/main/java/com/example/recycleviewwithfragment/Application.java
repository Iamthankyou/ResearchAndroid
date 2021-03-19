package com.example.recycleviewwithfragment;

import java.util.ArrayList;

public class Application extends android.app.Application {
    public static ArrayList<Person> listPerson;

    @Override
    public void onCreate() {
        super.onCreate();

        listPerson = new ArrayList<>();
        listPerson.add(new Person("Pham Thi Thu Hien", "0984402978"));
        listPerson.add(new Person("Le Quang Duy", "0392301017"));


    }
}
