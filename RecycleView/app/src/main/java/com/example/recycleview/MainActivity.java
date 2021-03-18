package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter personAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> listPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listPerson = new ArrayList<>();

        for (int i=0; i<100; i++){
            listPerson.add(new Person("Pham Thi Thu Hien","2000","img1"));
        }

        personAdapter = new PersonAdapter(this,listPerson);

        recyclerView.setAdapter(personAdapter);


    }
}