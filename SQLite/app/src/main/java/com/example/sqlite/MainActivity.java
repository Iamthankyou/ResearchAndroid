package com.example.sqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etId,etName,etYear;
    private Button btnInsert,btnUpdate,btnDelete;
    private MyDbHelper db;

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

        btnInsert = (Button)findViewById(R.id.btnSubmit);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        btnInsert.setOnClickListener(e -> {
            db.insertStudent(new Student(Integer.parseInt(etId.getText().toString()),etName.getText().toString(),etYear.getText().toString()));
        });
    }
}



