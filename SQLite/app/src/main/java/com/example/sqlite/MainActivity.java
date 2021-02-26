package com.example.sqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etId,etName,etYear;
    private Button btnInsert,btnUpdate,btnDelete;
    private MyDbHelper db;
    private ListView listStudent;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDbHelper(MainActivity.this);

        etId = (EditText)findViewById(R.id.etId);
        etName = (EditText)findViewById(R.id.etFullName);
        etYear = (EditText)findViewById(R.id.etYear);
        listStudent = (ListView)findViewById(R.id.listStudent);

        btnInsert = (Button)findViewById(R.id.btnSubmit);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        ArrayList<Student> list = db.getAllStudents();

        StudentAdapter studentAdapter = new StudentAdapter(this,R.layout.activity_student_view,list);

        listStudent.setAdapter(studentAdapter);

        btnInsert.setOnClickListener(e -> {
            db.insertStudent(new Student(Integer.parseInt(etId.getText().toString()),etName.getText().toString(),etYear.getText().toString()));
        });

    }
}



