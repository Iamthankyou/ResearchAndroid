package com.example.customlistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        ArrayList<Student> students  = new ArrayList<Student>();

        students.add(new Student("Juno Okyo",2000));
        students.add(new Student("Juno Okyo",2000));
        students.add(new Student("Juno Okyo",2000));

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,R.layout.activity_custom_list_view,students);
        listView.setAdapter(adapter);

    }
}