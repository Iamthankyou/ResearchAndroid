package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter personAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;
    ArrayList<Person> listPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        layoutManager = new GridLayoutManager(this,5,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        listPerson = new ArrayList<>();

        for (int i=0; i<100; i++){
            listPerson.add(new Person("Pham Thi Thu Hien","2000","img1"));
        }

        personAdapter = new PersonAdapter(this,listPerson);

        recyclerView.setAdapter(personAdapter);


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPerson.add(new Person("Le Quang Duy","2000","img1"));
                personAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,listPerson.get(position).getName(),Toast.LENGTH_LONG).show();
    }
}