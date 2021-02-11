package com.example.customlistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText filter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = (EditText)findViewById(R.id.filter);
        listView = (ListView)findViewById(R.id.listView);
        ArrayList<Student> students  = new ArrayList<Student>();

        students.add(new Student("Juno Okyo",2000));
        students.add(new Student("Juno Okyo",2000));
        students.add(new Student("Juno Okyo",2000));

        CustomBaseAdapter adapter = new CustomBaseAdapter(MainActivity.this,students);
        listView.setAdapter(adapter);

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}